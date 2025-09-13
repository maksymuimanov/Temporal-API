package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.pool.SimpleStrategyPool;
import com.temporal.api.core.engine.metadata.pool.StrategyPool;

import java.util.Set;

public abstract class AbstractAnnotationProcessor implements AnnotationProcessor {
    private final StrategyPool strategyPool;

    public AbstractAnnotationProcessor() {
        this(SimpleStrategyPool.getInstance());
    }

    public AbstractAnnotationProcessor(StrategyPool strategyPool) {
        this.strategyPool = strategyPool;
    }

    public void process() {
        consumer.execute(MetadataLayer.CLASS_EXECUTOR, strategyPool.getAll(StrategyPoolInitializer.DEFAULT_CLASS_DATA), classes);
    }

    @Override
    public void process(Set<Class<?>> classes) {
        this.process(this.strategyPool, classes);
    }

    public abstract void process(StrategyPool strategyPool, Set<Class<?>> classes);
}
