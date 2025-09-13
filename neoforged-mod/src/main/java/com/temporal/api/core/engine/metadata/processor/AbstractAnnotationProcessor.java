package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.consumer.AnnotationStrategyConsumer;
import com.temporal.api.core.engine.metadata.pool.SimpleStrategyPool;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractAnnotationProcessor implements AnnotationProcessor {
    protected void processSimple(String name, Set<Class<?>> classes) {
        this.processAll(MetadataLayer.SIMPLE_STRATEGY_CONSUMER, name, classes);
    }

    protected void processAsync(String name, Set<Class<?>> classes) {
        this.processAll(MetadataLayer.ASYNC_STRATEGY_CONSUMER, name, classes);
    }

    protected void processAll(AnnotationStrategyConsumer consumer, String name, Set<Class<?>> classes) {
        SimpleStrategyPool strategyPool = SimpleStrategyPool.getInstance();
        Map<Class<? extends Annotation>, List<AnnotationStrategy<?, ?>>> annotationStrategies = strategyPool.getAll(name);
        consumer.execute(annotationStrategies, classes);
    }
}
