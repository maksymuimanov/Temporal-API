package com.temporal.api.core.engine.metadata.consumer;

import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;

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
    public void execute(Map<Class<? extends Annotation>, List<AnnotationStrategy<?, ?>>> strategies, Set<Class<?>> source) {
        ExecutorService pool = Executors.newWorkStealingPool();
        try {
            List<CompletableFuture<Void>> futures = new ArrayList<>();
            for (Class<?> clazz : source) {
                futures.add(CompletableFuture.runAsync(() -> {
                    strategies.forEach((annotation, list) -> {
                        list.forEach(strategy -> {
                            AnnotationExecutor<AnnotationStrategy<?, ?>> executor = (AnnotationExecutor<AnnotationStrategy<?, ?>>) strategy.getExecutor();
                            executor.tryExecute(strategy, clazz);
                        });
                    });
                }, pool));
            }

            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        } finally {
            pool.shutdown();
        }
    }
}
