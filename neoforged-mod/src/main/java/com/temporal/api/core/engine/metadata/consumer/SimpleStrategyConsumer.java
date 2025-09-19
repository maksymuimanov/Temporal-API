package com.temporal.api.core.engine.metadata.consumer;

import com.temporal.api.core.engine.metadata.processor.StrategySpec;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;

import java.util.Set;

public class SimpleStrategyConsumer implements AnnotationStrategyConsumer {
    @Override
    public void execute(Iterable<StrategySpec<?>> strategies, Set<Class<?>> source) {
        strategies.forEach(strategySpec -> {
            AnnotationStrategy<Object, ?> strategy = (AnnotationStrategy<Object, ?>) strategySpec.strategy();
            Object type = strategySpec.type();
            try {
                strategy.execute(type, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
