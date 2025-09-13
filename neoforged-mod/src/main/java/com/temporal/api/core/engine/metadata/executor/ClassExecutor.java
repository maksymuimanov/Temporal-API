package com.temporal.api.core.engine.metadata.executor;

import com.temporal.api.core.engine.metadata.strategy.type.ClassAnnotationStrategy;

import java.lang.annotation.Annotation;

public class ClassExecutor implements AnnotationExecutor<ClassAnnotationStrategy<?>> {
    @Override
    public void execute(ClassAnnotationStrategy<?> strategy, Class<?> clazz) throws Exception {
        try {
            Annotation[] annotations = clazz.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                Class<? extends Annotation> annotationType = annotation.annotationType();
                if (annotationType.equals(strategy.getAnnotationClass())) {
                    strategy.execute(clazz, null);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
