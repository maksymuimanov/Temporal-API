package com.temporal.api.core.engine.initialization.initializer;

import com.temporal.api.core.engine.context.ObjectPool;
import com.temporal.api.core.engine.event.handler.EventHandler;
import com.temporal.api.core.engine.event.pool.EventHandlerPool;
import com.temporal.api.core.engine.event.pool.SimpleEventHandlerPool;
import com.temporal.api.core.engine.metadata.annotation.injection.Handler;
import net.neoforged.bus.api.Event;

import java.util.List;

public class EventHandlerPoolInitializer implements ObjectPoolInitializer {
    @Override
    @SuppressWarnings("unchecked")
    public void initialize(Iterable<Class<?>> classes, List<?> externalObjects, ObjectPool objectPool) {
        EventHandlerPool eventHandlerPool = new SimpleEventHandlerPool();
        classes.forEach(clazz -> {
                    if (!clazz.isAnnotationPresent(Handler.class)) return;
                    Handler annotation = clazz.getDeclaredAnnotation(Handler.class);
                    if (!Event.class.equals(annotation.override())) {
                        eventHandlerPool.remove(annotation.override());
                    }
                    eventHandlerPool.put(annotation.value(), (Class<? extends EventHandler>) clazz);
                });
        objectPool.put(eventHandlerPool);
    }
}
