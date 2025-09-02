package com.temporal.api.core.engine.metadata.strategy;

import java.lang.annotation.Annotation;

public interface AnnotationStrategy<T, A extends Annotation> {
    void execute(T t, Object object) throws Exception;

    void execute(T t, Object object, A annotation) throws Exception;

    Class<? extends A> getAnnotationClass();
}
