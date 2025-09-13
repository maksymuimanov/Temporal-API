package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.consumer.AnnotationStrategyConsumer;
import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.pool.SimpleStrategyPool;
import com.temporal.api.core.engine.metadata.pool.StrategyPool;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Set;

public abstract class AbstractAnnotationProcessor implements AnnotationProcessor {
    private final StrategyPool strategyPool;

    public AbstractAnnotationProcessor() {
        this(SimpleStrategyPool.getInstance());
    }

    public AbstractAnnotationProcessor(StrategyPool strategyPool) {
        this.strategyPool = strategyPool;
    }

    @Override
    public void process(Set<Class<?>> classes) {
        this.process(this.strategyPool, classes);
    }

    protected abstract void process(StrategyPool strategyPool, Set<Class<?>> classes);

    protected <T extends AnnotationStrategy<?, ?>> void processSimple(AnnotationExecutor<T> executor, String name, Set<Class<?>> classes) {
        this.processAll(MetadataLayer.SIMPLE_STRATEGY_CONSUMER, executor, name, classes);
    }

    protected <T extends AnnotationStrategy<?, ?>> void processAsync(AnnotationExecutor<T> executor, String name, Set<Class<?>> classes) {
        this.processAll(MetadataLayer.ASYNC_STRATEGY_CONSUMER, executor, name, classes);
    }

    @SuppressWarnings("unchecked")
    protected <T extends AnnotationStrategy<?, ?>> void processAll(AnnotationStrategyConsumer consumer, AnnotationExecutor<T> executor, String name, Set<Class<?>> classes) {
        consumer.execute(executor, (Map<Class<? extends Annotation>, T>) this.strategyPool.getAll(name), classes);
    }
}
