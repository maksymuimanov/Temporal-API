package com.temporal.api.core.engine.metadata.processor;

import java.util.Set;

@FunctionalInterface
public interface AnnotationProcessor {
    void process(Set<Class<?>> classes);
}
