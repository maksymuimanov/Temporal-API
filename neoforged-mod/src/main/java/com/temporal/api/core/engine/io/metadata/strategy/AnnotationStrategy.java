package com.temporal.api.core.engine.io.metadata.strategy;

import java.lang.annotation.Annotation;

public interface AnnotationStrategy<T> {
    void execute(T t, Object object) throws Exception;

    Class<? extends Annotation> getAnnotationClass();
}
