package com.temporal.api.core.engine.metadata.pool;

import com.temporal.api.core.engine.metadata.processor.AnnotationProcessor;
import com.temporal.api.core.engine.metadata.processor.StrategySpec;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;

public interface ProcessorPool extends Iterable<AnnotationProcessor> {
    <T extends AnnotationProcessor> T get(String name);

    <T extends AnnotationProcessor> T get(ProcessorScope scope);

    void processAll();

    <T> void subscribe(AnnotationStrategy<T, ?> strategy, T type);

    <T> void subscribe(StrategySpec<T> strategySpec);

    void put(ProcessorScope scope, Class<? extends AnnotationProcessor> processorClass);

    void put(ProcessorScope scope, AnnotationProcessor processor);

    void override(ProcessorScope scope, Class<? extends AnnotationProcessor> to);

    void override(ProcessorScope scope, AnnotationProcessor to);

    void remove(ProcessorScope processorScope);

    boolean contains(String name);

    boolean contains(ProcessorScope scope);
}
