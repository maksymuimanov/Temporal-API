package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.metadata.consumer.AnnotationStrategyConsumer;
import com.temporal.api.core.engine.metadata.pool.SimpleStrategyPool;
import com.temporal.api.core.engine.metadata.pool.StrategyPool;

import java.util.Set;

@FunctionalInterface
public interface AnnotationProcessor {
    default void process(AnnotationStrategyConsumer consumer, Set<Class<?>> classes) {
        final StrategyPool strategyPool = SimpleStrategyPool.getInstance();
        this.process(consumer, strategyPool, classes);
    }

    void process(AnnotationStrategyConsumer consumer, StrategyPool strategyPool, Set<Class<?>> classes);
}
