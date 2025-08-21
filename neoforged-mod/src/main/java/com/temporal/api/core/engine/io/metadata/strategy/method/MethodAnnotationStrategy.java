package com.temporal.api.core.engine.io.metadata.strategy.method;

import com.temporal.api.core.engine.io.metadata.annotation.injection.Execute;
import com.temporal.api.core.engine.io.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public interface MethodAnnotationStrategy<A extends Annotation> extends AnnotationStrategy<Method, A> {
    @Override
    default void execute(Method method, Object object) throws Exception {
        method.setAccessible(true);
        A annotation = method.getDeclaredAnnotation(this.getAnnotationClass());
        this.execute(method, object, annotation);
    }
}
