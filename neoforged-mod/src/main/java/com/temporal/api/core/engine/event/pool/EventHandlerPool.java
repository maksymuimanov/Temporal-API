package com.temporal.api.core.engine.event.pool;

import com.temporal.api.core.engine.event.handler.EventHandler;
import net.neoforged.bus.api.Event;

import java.util.Collection;
import java.util.List;

public interface EventHandlerPool extends Iterable<EventHandler> {
    List<EventHandler> getAll(Collection<Class<? extends Event>> eventClasses);

    @SuppressWarnings("unchecked")
    List<EventHandler> getAll(Class<? extends Event> eventClass, Class<? extends Event>... eventClasses);

    <E extends EventHandler> List<E> get(Class<? extends Event> eventClass);

    void put(Class<? extends Event> eventClass, Class<? extends EventHandler> eventHandlerClass);

    <E extends EventHandler> void put(Class<? extends Event> eventClass, E eventHandler);

    void remove(Class<? extends Event> eventClass);

    boolean contains(Class<? extends Event> eventClass);
}
