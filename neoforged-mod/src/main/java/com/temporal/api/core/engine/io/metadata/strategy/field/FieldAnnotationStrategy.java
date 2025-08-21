package com.temporal.api.core.engine.io.metadata.strategy.field;

import com.temporal.api.core.engine.io.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public interface FieldAnnotationStrategy<A extends Annotation> extends AnnotationStrategy<Field, A> {
    @Override
    default void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        A annotation = field.getDeclaredAnnotation(this.getAnnotationClass());
        this.execute(field, object, annotation);
    }
}
