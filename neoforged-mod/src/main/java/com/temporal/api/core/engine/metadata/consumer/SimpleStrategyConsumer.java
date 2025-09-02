package com.temporal.api.core.engine.metadata.consumer;

import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Set;

public class SimpleStrategyConsumer implements AnnotationStrategyConsumer {
    @Override
    public <T extends AnnotationStrategy<?, ?>> void execute(AnnotationExecutor<T> executor, Map<Class<? extends Annotation>, T> strategies, Set<Class<?>> source) {
        source.forEach(clazz -> {
            executor.tryExecute(strategies, clazz);
        });
    }
}
