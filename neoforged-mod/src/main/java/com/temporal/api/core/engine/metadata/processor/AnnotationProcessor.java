package com.temporal.api.core.engine.metadata.processor;

public interface AnnotationProcessor {
    void process();

    void subscribe(StrategySpec<?> annotationStrategy);
}
