package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;

import java.util.Set;

public class DataAnnotationProcessor extends AbstractAnnotationProcessor {
    @Override
    public void process(Set<Class<?>> classes) {
        this.processAsync(StrategyPoolInitializer.DEFAULT_CLASS_DATA, classes);
        this.processAsync(StrategyPoolInitializer.DEFAULT_FIELD_DATA, classes);
    }
}
