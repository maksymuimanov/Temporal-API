package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.strategy.method.MethodAnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.method.injection.ExecuteStrategy;
import com.temporal.api.core.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

public class MethodAnnotationProcessor implements AnnotationProcessor<MethodAnnotationStrategy<?>> {
    private final Map<Class<? extends Annotation>, MethodAnnotationStrategy<?>> strategies = ReflectionUtils.createAnnotationStrategyMap(List.of(
            new ExecuteStrategy()
    ));

    @Override
    public AnnotationExecutor<MethodAnnotationStrategy<?>> getExecutor() {
        return MetadataLayer.METHOD_EXECUTOR;
    }

    @Override
    public Map<Class<? extends Annotation>, MethodAnnotationStrategy<?>> getStrategies() {
        return strategies;
    }
}
