package com.temporal.api.core.engine.metadata.consumer;

import com.temporal.api.core.engine.metadata.processor.StrategySpec;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncStrategyConsumer implements AnnotationStrategyConsumer {
    @Override
    public void execute(Iterable<StrategySpec<?>> strategies, Set<Class<?>> source) {
        ExecutorService pool = Executors.newWorkStealingPool();
        try {
            List<CompletableFuture<Void>> futures = new ArrayList<>();
            futures.add(CompletableFuture.runAsync(() -> {
                strategies.forEach(strategySpec -> {
                    AnnotationStrategy<Object, ?> strategy = (AnnotationStrategy<Object, ?>) strategySpec.strategy();
                    Object type = strategySpec.type();
                    try {
                        strategy.execute(type, null);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            }, pool));
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        } finally {
            pool.shutdown();
        }
    }
}
