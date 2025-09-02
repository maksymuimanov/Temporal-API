package com.temporal.api.core.engine.metadata.executor;

import com.temporal.api.core.engine.metadata.strategy.type.ClassAnnotationStrategy;

import java.lang.annotation.Annotation;
import java.util.Map;

public class ClassExecutor implements AnnotationExecutor<ClassAnnotationStrategy<?>> {
    @Override
    public void execute(Map<Class<? extends Annotation>, ClassAnnotationStrategy<?>> strategies, Class<?> clazz) throws Exception {
        try {
            Annotation[] annotations = clazz.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                Class<? extends Annotation> annotationType = annotation.annotationType();
                ClassAnnotationStrategy<?> strategy = strategies.get(annotationType);
                if (strategy != null) {
                    strategy.execute(clazz, null);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
