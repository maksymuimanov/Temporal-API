package com.temporal.api.core.engine.io.metadata.consumer;

import com.temporal.api.core.engine.io.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.io.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncStrategyConsumer implements AnnotationStrategyConsumer {
    @Override
    public <T extends AnnotationStrategy<?, ?>> void execute(AnnotationExecutor<T> executor, Map<Class<? extends Annotation>, T> strategies, Set<Class<?>> source) {
        ExecutorService pool = Executors.newWorkStealingPool();
        try {
            List<CompletableFuture<Void>> futures = new ArrayList<>();
            for (Class<?> clazz : source) {
                futures.add(CompletableFuture.runAsync(() -> {
                    executor.tryExecute(strategies, clazz);
                }, pool));
            }

            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        } finally {
            pool.shutdown();
        }
    }
}
