package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.pool.SimpleStrategyPool;
import com.temporal.api.core.engine.metadata.strategy.type.ClassAnnotationStrategy;

import java.lang.annotation.Annotation;
import java.util.Map;

public class DataClassAnnotationProcessor implements AnnotationProcessor<ClassAnnotationStrategy<?>> {
    @Override
    public AnnotationExecutor<ClassAnnotationStrategy<?>> getExecutor() {
        return MetadataLayer.CLASS_EXECUTOR;
    }

    @Override
    public Map<Class<? extends Annotation>, ClassAnnotationStrategy<?>> getStrategies() {
        return SimpleStrategyPool.getInstance().getStrategies(StrategyPoolInitializer.DEFAULT_CLASS_DATA);
    }
}
