package com.temporal.api.core.engine.metadata.strategy;

import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;

import java.lang.annotation.Annotation;

public interface AnnotationStrategy<T, A extends Annotation> {
    void execute(T t, Object object) throws Exception;

    void execute(T t, Object object, A annotation) throws Exception;

    Class<? extends A> getAnnotationClass();

    AnnotationExecutor<? extends AnnotationStrategy<T, ?>> getExecutor();
}
