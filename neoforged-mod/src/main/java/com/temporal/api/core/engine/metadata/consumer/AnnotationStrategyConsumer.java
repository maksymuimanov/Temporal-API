package com.temporal.api.core.engine.metadata.consumer;

import com.temporal.api.core.engine.metadata.processor.StrategySpec;

import java.util.Set;

public interface AnnotationStrategyConsumer {
    void execute(Iterable<StrategySpec<?>> strategies, Set<Class<?>> source);
}
