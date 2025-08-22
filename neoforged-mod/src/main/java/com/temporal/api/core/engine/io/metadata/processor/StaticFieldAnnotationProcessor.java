package com.temporal.api.core.engine.io.metadata.processor;

import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.engine.io.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.field.injection.RegisterFactoryFieldStrategy;
import com.temporal.api.core.util.IOUtils;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

public class StaticFieldAnnotationProcessor implements AnnotationProcessor<FieldAnnotationStrategy<?>> {
    private final Map<Class<? extends Annotation>, FieldAnnotationStrategy<?>> strategies = IOUtils.createAnnotationStrategyMap(List.of(
            new RegisterFactoryFieldStrategy()
    ));

    @Override
    public AnnotationExecutor<FieldAnnotationStrategy<?>> getExecutor() {
        return IOLayer.STATIC_FIELD_EXECUTOR;
    }

    @Override
    public Map<Class<? extends Annotation>, FieldAnnotationStrategy<?>> getStrategies() {
        return strategies;
    }
}
