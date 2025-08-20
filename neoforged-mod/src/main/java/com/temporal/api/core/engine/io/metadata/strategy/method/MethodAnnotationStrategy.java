package com.temporal.api.core.engine.io.metadata.strategy.method;

import com.temporal.api.core.engine.io.metadata.strategy.AnnotationStrategy;

import java.lang.reflect.Method;

public interface MethodAnnotationStrategy extends AnnotationStrategy<Method> {
    void execute(Method method, Object object) throws Exception;
}
