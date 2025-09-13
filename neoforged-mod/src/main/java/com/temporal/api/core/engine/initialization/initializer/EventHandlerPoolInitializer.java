package com.temporal.api.core.engine.initialization.initializer;

import com.temporal.api.core.engine.context.ObjectPool;
import com.temporal.api.core.engine.event.handler.EventHandler;
import com.temporal.api.core.engine.event.pool.HandlerPool;
import com.temporal.api.core.engine.event.pool.SimpleHandlerPool;
import com.temporal.api.core.engine.metadata.annotation.injection.Handler;

import java.util.List;

public class EventHandlerPoolInitializer implements ObjectPoolInitializer {
    @Override
    @SuppressWarnings("unchecked")
    public void initialize(Iterable<Class<?>> classes, List<?> externalObjects, ObjectPool objectPool) {
        HandlerPool handlerPool = new SimpleHandlerPool();
        classes.forEach(clazz -> {
            if (!clazz.isAnnotationPresent(Handler.class)) return;
            Handler annotation = clazz.getDeclaredAnnotation(Handler.class);
            Class<? extends EventHandler> eventHandlerClass = (Class<? extends EventHandler>) clazz;
            if (!EventHandler.class.equals(annotation.override())) {
                handlerPool.override(annotation.value(), eventHandlerClass, annotation.override());
            } else {
                handlerPool.put(annotation.value(), eventHandlerClass);
            }
        });
        objectPool.put(handlerPool);
    }
}
