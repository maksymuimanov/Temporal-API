package com.temporal.api.core.engine.io.metadata.consumer;

import com.temporal.api.core.engine.io.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.io.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Set;

public interface AnnotationStrategyConsumer {
    <T extends AnnotationStrategy<?, ?>> void execute(AnnotationExecutor<T> executor, Map<Class<? extends Annotation>, T> strategies, Set<Class<?>> source);
}
