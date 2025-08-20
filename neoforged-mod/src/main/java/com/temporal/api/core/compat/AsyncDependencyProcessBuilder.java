package com.temporal.api.core.compat;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.event.handler.EventHandler;
import net.neoforged.fml.ModList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AsyncDependencyProcessBuilder extends AbstractDependencyProcessBuilder<AsyncDependencyProcessBuilder> {
    private static final byte DEFAULT_FIXED_THREAD_POOL_COUNT = 3;
    private static final long DEFAULT_TIMEOUT = 30L;
    private final ExecutorService threadPool;
    private final boolean isTerminable;

    protected AsyncDependencyProcessBuilder(ExecutorService threadPool, boolean isTerminable, List<String> dependencyIds) {
        super(dependencyIds);
        this.threadPool = threadPool;
        this.isTerminable = isTerminable;
    }

    public static AsyncDependencyProcessBuilder create(String dependencyId, String... additionalDependencyIds) {
        return create(DEFAULT_FIXED_THREAD_POOL_COUNT, dependencyId, additionalDependencyIds);
    }

    public static AsyncDependencyProcessBuilder create(byte fixedThreadPoolCount, String dependencyId, String... additionalDependencyIds) {
        return create(Executors.newFixedThreadPool(fixedThreadPoolCount), dependencyId, additionalDependencyIds);
    }

    public static AsyncDependencyProcessBuilder create(ExecutorService threadPool, String dependencyId, String... additionalDependencyIds) {
        return create(threadPool, true, dependencyId, additionalDependencyIds);
    }

    public static AsyncDependencyProcessBuilder create(ExecutorService threadPool, boolean isTerminable, String dependencyId, String... additionalDependencyIds) {
        List<String> ids = new ArrayList<>(additionalDependencyIds.length + 1);
        ids.add(dependencyId);
        ids.addAll(List.of(additionalDependencyIds));
        return new AsyncDependencyProcessBuilder(threadPool, isTerminable, ids);
    }

    @Override
    public AsyncDependencyProcessBuilder addProcess(EventHandler eventHandler) {
        return this.addProcess((DependencyFunction) eventHandler::handle);
    }

    @Override
    public AsyncDependencyProcessBuilder addProcess(DependencyFunction callback) {
        for (String dependencyId : this.getDependencyIds()) {
            if (!ModList.get().isLoaded(dependencyId)) {
                ApiMod.LOGGER.warn("Dependency: \"{}\" is not found, so dependency process won't be added to callbacks: {}", dependencyId, callback.toString());
                return this;
            }
        }

        this.addCallback(callback);
        return this;
    }

    @Override
    public AsyncDependencyProcessBuilder startNext(String dependencyId, String... additionalDependencyIds) {
        this.build();
        return create(dependencyId, additionalDependencyIds);
    }

    @Override
    public void build() {
        try {
            List<CompletableFuture<Void>> futures = this.getCallbacks().stream()
                    .map(callback -> CompletableFuture.runAsync(() -> {
                        try {
                            callback.execute();
                        } catch (Exception e) {
                            ApiMod.LOGGER.error("Error while running dependency process", e);
                            throw new RuntimeException(e);
                        }}, threadPool))
                    .toList();
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        } finally {
            if (isTerminable) {
                threadPool.shutdown();
                try {
                    if (!threadPool.awaitTermination(DEFAULT_TIMEOUT, TimeUnit.SECONDS)) {
                        threadPool.shutdownNow();
                    }
                } catch (InterruptedException e) {
                    threadPool.shutdownNow();
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
