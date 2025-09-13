package com.temporal.api.core.engine.initialization.initializer;

import com.temporal.api.core.engine.context.ObjectPool;
import com.temporal.api.core.engine.event.handler.EventHandler;
import com.temporal.api.core.engine.event.pool.HandlerPool;
import com.temporal.api.core.engine.event.pool.SimpleHandlerPool;
import com.temporal.api.core.engine.metadata.annotation.injection.Handler;

import java.util.Collection;
import java.util.List;

public class HandlerPoolInitializer implements ObjectPoolInitializer {
    @Override
    @SuppressWarnings("unchecked")
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectPool objectPool) {
        HandlerPool handlerPool = new SimpleHandlerPool();
        classes.stream()
                .filter(clazz -> clazz.isAnnotationPresent(Handler.class))
                .sorted((c1, c2) -> {
                    Handler a1 = c1.getDeclaredAnnotation(Handler.class);
                    Handler a2 = c2.getDeclaredAnnotation(Handler.class);
                    boolean isA1Override = !EventHandler.class.equals(a1.override());
                    boolean isA2Override = !EventHandler.class.equals(a2.override());
                    if (isA1Override && isA2Override) {
                        return 0;
                    } else if (isA1Override) {
                        return 1;
                    } else if (isA2Override) {
                        return -1;
                    } else {
                        return 0;
                    }
                }).forEach(clazz -> {
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
