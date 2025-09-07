package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.consumer.AnnotationStrategyConsumer;
import com.temporal.api.core.engine.metadata.pool.StrategyPool;

import java.util.Set;

public class DataAnnotationProcessor implements AnnotationProcessor {
    @Override
    public void process(AnnotationStrategyConsumer consumer, StrategyPool strategyPool, Set<Class<?>> classes) {
        consumer.execute(MetadataLayer.CLASS_EXECUTOR, strategyPool.getStrategies(StrategyPoolInitializer.DEFAULT_CLASS_DATA), classes);
        consumer.execute(MetadataLayer.STATIC_FIELD_EXECUTOR, strategyPool.getStrategies(StrategyPoolInitializer.DEFAULT_FIELD_DATA), classes);
    }
}
