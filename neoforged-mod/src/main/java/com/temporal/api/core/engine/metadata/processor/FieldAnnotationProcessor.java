package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.pool.SimpleStrategyPool;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;

import java.lang.annotation.Annotation;
import java.util.Map;

public class FieldAnnotationProcessor implements AnnotationProcessor<FieldAnnotationStrategy<?>> {
    @Override
    public AnnotationExecutor<FieldAnnotationStrategy<?>> getExecutor() {
        return MetadataLayer.FIELD_EXECUTOR;
    }

    @Override
    public Map<Class<? extends Annotation>, FieldAnnotationStrategy<?>> getStrategies() {
        return SimpleStrategyPool.getInstance().getStrategies(StrategyPoolInitializer.DEFAULT_FIELD_INJECTION);
    }
}
