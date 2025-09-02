package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

public class StaticFieldAnnotationProcessor implements AnnotationProcessor<FieldAnnotationStrategy<?>> {
    private final Map<Class<? extends Annotation>, FieldAnnotationStrategy<?>> strategies = ReflectionUtils.createAnnotationStrategyMap(List.of(
    ));

    @Override
    public AnnotationExecutor<FieldAnnotationStrategy<?>> getExecutor() {
        return MetadataLayer.STATIC_FIELD_EXECUTOR;
    }

    @Override
    public Map<Class<? extends Annotation>, FieldAnnotationStrategy<?>> getStrategies() {
        return strategies;
    }
}
