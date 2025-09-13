package com.temporal.api.core.engine.metadata.executor;

import com.temporal.api.core.engine.metadata.strategy.method.MethodAnnotationStrategy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class StaticMethodExecutor implements AnnotationExecutor<MethodAnnotationStrategy<?>> {
    @Override
    public void execute(MethodAnnotationStrategy<?> strategy, Class<?> clazz) throws Exception {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            try {
                Annotation[] annotations = method.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    Class<? extends Annotation> annotationType = annotation.annotationType();
                    if (annotationType.equals(strategy.getAnnotationClass())) {
                        strategy.execute(method, null);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
