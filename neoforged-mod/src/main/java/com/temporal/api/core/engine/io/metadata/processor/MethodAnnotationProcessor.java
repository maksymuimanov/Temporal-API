package com.temporal.api.core.engine.io.metadata.processor;

import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.engine.io.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.io.metadata.strategy.method.MethodAnnotationStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.method.injection.ExecuteStrategy;
import com.temporal.api.core.util.IOUtils;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

public class MethodAnnotationProcessor implements AnnotationProcessor<MethodAnnotationStrategy<?>> {
    private final Map<Class<? extends Annotation>, MethodAnnotationStrategy<?>> strategies = IOUtils.createAnnotationStrategyMap(List.of(
            new ExecuteStrategy()
    ));

    @Override
    public AnnotationExecutor<MethodAnnotationStrategy<?>> getExecutor() {
        return IOLayer.METHOD_EXECUTOR;
    }

    @Override
    public Map<Class<? extends Annotation>, MethodAnnotationStrategy<?>> getStrategies() {
        return strategies;
    }
}
