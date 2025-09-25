package com.temporal.api.core.engine.metadata.strategy;

import com.temporal.api.core.engine.metadata.pool.ProcessorScope;

import java.lang.annotation.Annotation;

public interface AnnotationStrategy<T, A extends Annotation> {
    void execute(T t, Object object) throws Exception;

    void execute(T t, Object object, A annotation) throws Exception;

    Class<A> getAnnotationClass();

    Class<? super T> getTypeClass();

    ProcessorScope getProcessorScope();
}
