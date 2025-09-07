package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.consumer.AnnotationStrategyConsumer;
import com.temporal.api.core.engine.metadata.pool.StrategyPool;

import java.util.Set;

public class InjectionAnnotationProcessor implements AnnotationProcessor {
    @Override
    public void process(AnnotationStrategyConsumer consumer, StrategyPool strategyPool, Set<Class<?>> classes) {
        consumer.execute(MetadataLayer.FIELD_EXECUTOR, strategyPool.getStrategies(StrategyPoolInitializer.DEFAULT_FIELD_INJECTION), classes);
        consumer.execute(MetadataLayer.METHOD_EXECUTOR, strategyPool.getStrategies(StrategyPoolInitializer.DEFAULT_METHOD_INJECTION), classes);
    }
}
