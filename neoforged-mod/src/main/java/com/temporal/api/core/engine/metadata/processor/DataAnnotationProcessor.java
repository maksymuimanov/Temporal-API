package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.pool.StrategyPool;

import java.util.Set;

public class DataAnnotationProcessor extends AbstractAnnotationProcessor {
    @Override
    protected void process(StrategyPool strategyPool, Set<Class<?>> classes) {
        this.processAsync(MetadataLayer.CLASS_EXECUTOR, StrategyPoolInitializer.DEFAULT_CLASS_DATA, classes);
        this.processAsync(MetadataLayer.STATIC_FIELD_EXECUTOR, StrategyPoolInitializer.DEFAULT_FIELD_DATA, classes);
    }
}
