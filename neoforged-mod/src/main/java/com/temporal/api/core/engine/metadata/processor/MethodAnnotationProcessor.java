package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.pool.SimpleStrategyPool;
import com.temporal.api.core.engine.metadata.strategy.method.MethodAnnotationStrategy;

import java.lang.annotation.Annotation;
import java.util.Map;

public class MethodAnnotationProcessor implements AnnotationProcessor<MethodAnnotationStrategy<?>> {
    @Override
    public AnnotationExecutor<MethodAnnotationStrategy<?>> getExecutor() {
        return MetadataLayer.METHOD_EXECUTOR;
    }

    @Override
    public Map<Class<? extends Annotation>, MethodAnnotationStrategy<?>> getStrategies() {
        return SimpleStrategyPool.getInstance().getStrategies(StrategyPoolInitializer.DEFAULT_METHOD_INJECTION);
    }
}
