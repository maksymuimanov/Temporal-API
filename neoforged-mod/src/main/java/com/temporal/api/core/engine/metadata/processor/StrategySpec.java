package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;

public record StrategySpec<T>(AnnotationStrategy<T, ?> strategy, T type) {
}
