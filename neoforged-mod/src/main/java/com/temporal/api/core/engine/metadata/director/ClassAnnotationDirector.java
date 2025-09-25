package com.temporal.api.core.engine.metadata.director;

import com.temporal.api.core.engine.metadata.pool.ProcessorPool;
import com.temporal.api.core.engine.metadata.pool.SimpleProcessorPool;
import com.temporal.api.core.engine.metadata.pool.SimpleStrategyPool;
import com.temporal.api.core.engine.metadata.pool.StrategyPool;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.Annotation;

public class ClassAnnotationDirector implements AnnotationDirector {
    @Override
    public void direct(Class<?> clazz) throws Exception {
        try {
            Annotation[] annotations = clazz.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                Class<? extends Annotation> annotationType = annotation.annotationType();
                StrategyPool strategyPool = SimpleStrategyPool.getInstance();
                var typeClass = Class.class;
                if (!strategyPool.contains(annotationType, typeClass)) continue;
                AnnotationStrategy<Class<?>, ? extends Annotation> strategy = strategyPool.get(annotationType, typeClass);
                ProcessorPool processorPool = SimpleProcessorPool.getInstance();
                processorPool.subscribe(strategy, clazz);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
