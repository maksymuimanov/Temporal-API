package com.temporal.api.core.engine.metadata.consumer;

import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AnnotationStrategyConsumer {
    void execute(Map<Class<? extends Annotation>, List<AnnotationStrategy<?, ?>>> strategies, Set<Class<?>> source);
}
