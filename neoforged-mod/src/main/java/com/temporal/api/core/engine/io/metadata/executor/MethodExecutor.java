package com.temporal.api.core.engine.io.metadata.executor;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.engine.io.metadata.strategy.method.MethodAnnotationStrategy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Map;

public class MethodExecutor implements AnnotationExecutor<MethodAnnotationStrategy<?>> {
    @Override
    public void execute(Map<Class<? extends Annotation>, MethodAnnotationStrategy<?>> strategies, Class<?> clazz) throws Exception {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            try {
                Annotation[] annotations = method.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    Class<? extends Annotation> annotationType = annotation.annotationType();
                    MethodAnnotationStrategy<?> strategy = strategies.get(annotationType);
                    if (strategy != null) {
                        strategy.execute(method, InjectionPool.getFromInstance(clazz));
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
