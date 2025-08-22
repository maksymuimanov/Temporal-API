package com.temporal.api.core.engine.io.metadata.executor;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;

public class FieldExecutor implements AnnotationExecutor<FieldAnnotationStrategy<?>> {
    @Override
    public void execute(Map<Class<? extends Annotation>, FieldAnnotationStrategy<?>> strategies, Class<?> clazz) throws Exception {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                Annotation[] annotations = field.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    Class<? extends Annotation> annotationType = annotation.annotationType();
                    FieldAnnotationStrategy<?> strategy = strategies.get(annotationType);
                    if (strategy != null) {
                        strategy.execute(field, InjectionPool.getFromInstance(clazz));
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
