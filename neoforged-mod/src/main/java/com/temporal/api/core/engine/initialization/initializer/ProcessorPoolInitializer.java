package com.temporal.api.core.engine.initialization.initializer;

import com.temporal.api.core.engine.context.ObjectPool;
import com.temporal.api.core.engine.metadata.annotation.injection.Processor;
import com.temporal.api.core.engine.metadata.pool.ProcessorPool;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.pool.SimpleProcessorPool;
import com.temporal.api.core.engine.metadata.processor.AnnotationProcessor;
import com.temporal.api.core.util.ReflectionUtils;

import java.util.Collection;
import java.util.List;

public class ProcessorPoolInitializer implements ObjectPoolInitializer {
    @Override
    @SuppressWarnings("unchecked")
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectPool objectPool) {
        ProcessorPool processorPool = new SimpleProcessorPool();
        classes.stream()
                .filter(clazz -> clazz.isAnnotationPresent(Processor.class))
                .sorted(ReflectionUtils.compareByAnnotationOverrideMethodPresence(Processor.class))
                .forEach(clazz -> {
                    Processor annotation = clazz.getDeclaredAnnotation(Processor.class);
                    ProcessorScope scope = new ProcessorScope(annotation.value());
                    if (!AnnotationProcessor.class.equals(annotation.override())) {
                        processorPool.override(scope, annotation.override());
                    } else {
                        processorPool.put(scope, (Class<? extends AnnotationProcessor>) clazz);
                    }
                });
        objectPool.put(processorPool);
    }
}
