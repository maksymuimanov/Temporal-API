package com.temporal.api.core.engine.metadata.strategy.type;

import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.Annotation;

public interface ClassAnnotationStrategy<A extends Annotation> extends AnnotationStrategy<Class<?>, A> {
    @Override
    default void execute(Class<?> clazz, Object object) throws Exception {
        A annotation = clazz.getDeclaredAnnotation(this.getAnnotationClass());
        this.execute(clazz, object, annotation);
    }

    @Override
    void execute(Class<?> clazz, Object object, A annotation) throws Exception;

    @Override
    default AnnotationExecutor<? extends AnnotationStrategy<Class<?>, ?>> getExecutor() {
        return MetadataLayer.CLASS_EXECUTOR;
    }
}
