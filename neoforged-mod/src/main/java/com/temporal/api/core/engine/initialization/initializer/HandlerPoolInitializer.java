package com.temporal.api.core.engine.initialization.initializer;

import com.temporal.api.core.engine.context.ObjectPool;
import com.temporal.api.core.engine.event.handler.EventHandler;
import com.temporal.api.core.engine.event.pool.HandlerPool;
import com.temporal.api.core.engine.event.pool.SimpleHandlerPool;
import com.temporal.api.core.engine.metadata.annotation.injection.Handler;
import com.temporal.api.core.util.ReflectionUtils;

import java.util.Collection;
import java.util.List;

public class HandlerPoolInitializer implements ObjectPoolInitializer {
    @Override
    @SuppressWarnings("unchecked")
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectPool objectPool) {
        HandlerPool handlerPool = new SimpleHandlerPool();
        classes.stream()
                .filter(clazz -> clazz.isAnnotationPresent(Handler.class))
                .sorted(ReflectionUtils.compareByAnnotationOverrideMethodPresence(Handler.class))
                .forEach(clazz -> {
                    Handler annotation = clazz.getDeclaredAnnotation(Handler.class);
                    Class<? extends EventHandler> eventHandlerClass = (Class<? extends EventHandler>) clazz;
                    if (!EventHandler.class.equals(annotation.override())) {
                        handlerPool.override(annotation.value(), annotation.override(), eventHandlerClass);
                    } else {
                        handlerPool.put(annotation.value(), eventHandlerClass);
                    }
                });
        objectPool.put(handlerPool);
    }
}
