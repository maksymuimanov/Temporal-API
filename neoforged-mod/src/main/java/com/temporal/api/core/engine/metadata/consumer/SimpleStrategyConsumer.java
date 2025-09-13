package com.temporal.api.core.engine.metadata.consumer;

import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimpleStrategyConsumer implements AnnotationStrategyConsumer {
    @Override
    public void execute(Map<Class<? extends Annotation>, List<AnnotationStrategy<?, ?>>> strategies, Set<Class<?>> source) {
        source.forEach(clazz -> {
            strategies.forEach((annotation, list) -> {
                list.forEach(strategy -> {
                    AnnotationExecutor<AnnotationStrategy<?, ?>> executor = (AnnotationExecutor<AnnotationStrategy<?, ?>>) strategy.getExecutor();
                    executor.tryExecute(strategy, clazz);
                });
            });
        });
    }
}
