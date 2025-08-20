package com.temporal.api.core.engine.io.metadata.processor;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.io.metadata.consumer.AnnotationStrategyConsumer;
import com.temporal.api.core.engine.io.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.io.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Set;

public interface AnnotationProcessor<S extends AnnotationStrategy<?>> {
    default void process(Set<Class<?>> classes, AnnotationStrategyConsumer consumer) {
        try {
            consumer.execute(getExecutor(), getStrategies(), classes);
        } catch (Exception e) {
            ApiMod.LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    AnnotationExecutor<S> getExecutor();

    Map<Class<? extends Annotation>, S> getStrategies();
}
