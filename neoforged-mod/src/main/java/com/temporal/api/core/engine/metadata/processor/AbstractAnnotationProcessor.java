package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.metadata.consumer.AnnotationStrategyConsumer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public abstract class AbstractAnnotationProcessor implements AnnotationProcessor {
    private final Collection<StrategySpec<?>> subscribedStrategies;

    public AbstractAnnotationProcessor() {
        this(new ArrayList<>());
    }

    protected AbstractAnnotationProcessor(Collection<StrategySpec<?>> subscribedStrategies) {
        this.subscribedStrategies = subscribedStrategies;
    }

    @Override
    public void subscribe(StrategySpec<?> strategySpec) {
        this.subscribedStrategies.add(strategySpec);
    }

    protected void processAll(AnnotationStrategyConsumer consumer, Set<Class<?>> classes) {
        consumer.execute(this.subscribedStrategies, classes);
    }

    public Collection<StrategySpec<?>> getSubscribedStrategies() {
        return subscribedStrategies;
    }
}
