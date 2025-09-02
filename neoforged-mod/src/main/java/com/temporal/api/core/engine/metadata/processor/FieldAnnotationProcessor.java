package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.field.injection.DependencyStrategy;
import com.temporal.api.core.engine.metadata.strategy.field.injection.InjectStrategy;
import com.temporal.api.core.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

public class FieldAnnotationProcessor implements AnnotationProcessor<FieldAnnotationStrategy<?>> {
    private final Map<Class<? extends Annotation>, FieldAnnotationStrategy<?>> strategies = ReflectionUtils.createAnnotationStrategyMap(List.of(
            new InjectStrategy(),
            new DependencyStrategy()
    ));

    @Override
    public AnnotationExecutor<FieldAnnotationStrategy<?>> getExecutor() {
        return MetadataLayer.FIELD_EXECUTOR;
    }

    @Override
    public Map<Class<? extends Annotation>, FieldAnnotationStrategy<?>> getStrategies() {
        return strategies;
    }
}
