package com.temporal.api.core.engine.io.metadata.strategy.type;

import com.temporal.api.core.engine.io.metadata.strategy.AnnotationStrategy;

public interface ClassAnnotationStrategy extends AnnotationStrategy<Class<?>> {
    void execute(Class<?> clazz, Object object) throws Exception;
}
