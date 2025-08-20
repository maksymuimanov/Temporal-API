package com.temporal.api.core.engine.io.metadata.processor;

import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.engine.io.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.io.metadata.strategy.type.ClassAnnotationStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.type.injection.InjectedStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.type.injection.RegistryClassStrategy;
import com.temporal.api.core.util.other.IOUtils;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

public class ClassAnnotationProcessor implements AnnotationProcessor<ClassAnnotationStrategy> {
    private final Map<Class<? extends Annotation>, ClassAnnotationStrategy> strategies = IOUtils.createAnnotationStrategyMap(List.of(
            new InjectedStrategy(),
            new RegistryClassStrategy()
    ));

    @Override
    public AnnotationExecutor<ClassAnnotationStrategy> getExecutor() {
        return IOLayer.CLASS_EXECUTOR;
    }

    @Override
    public Map<Class<? extends Annotation>, ClassAnnotationStrategy> getStrategies() {
        return strategies;
    }
}
