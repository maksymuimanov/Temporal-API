package com.temporal.api.core.engine.metadata.executor;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class FieldExecutor implements AnnotationExecutor<FieldAnnotationStrategy<?>> {
    @Override
    public void execute(FieldAnnotationStrategy<?> strategy, Class<?> clazz) throws Exception {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                Annotation[] annotations = field.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    Class<? extends Annotation> annotationType = annotation.annotationType();
                    if (annotationType.equals(strategy.getAnnotationClass())) {
                        strategy.execute(field, InjectionPool.getFromInstance(clazz));
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
