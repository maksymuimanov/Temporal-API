package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.pool.StrategyPool;

import java.util.Set;

public class InjectionAnnotationProcessor extends AbstractAnnotationProcessor {
    @Override
    public void process(StrategyPool strategyPool, Set<Class<?>> classes) {
        MetadataLayer.ASYNC_STRATEGY_CONSUMER.execute(MetadataLayer.FIELD_EXECUTOR, strategyPool.getAll(StrategyPoolInitializer.DEFAULT_FIELD_INJECTION), classes);
        MetadataLayer.ASYNC_STRATEGY_CONSUMER.execute(MetadataLayer.METHOD_EXECUTOR, strategyPool.getAll(StrategyPoolInitializer.DEFAULT_METHOD_INJECTION), classes);
    }
}
