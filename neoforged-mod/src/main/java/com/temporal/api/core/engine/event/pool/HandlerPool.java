package com.temporal.api.core.engine.event.pool;

import com.temporal.api.core.engine.event.handler.EventHandler;
import net.neoforged.bus.api.Event;

import java.util.Collection;
import java.util.List;

public interface HandlerPool extends Iterable<EventHandler> {
    @SuppressWarnings("unchecked")
    List<EventHandler> getAll(Class<? extends Event> eventClass, Class<? extends Event>... eventClasses);

    List<EventHandler> getAll(Collection<Class<? extends Event>> eventClasses);

    List<EventHandler> get(Class<? extends Event> eventClass);

    List<EventHandler> get(HandlerScope handlerScope);

    void put(Class<? extends Event> eventClass, Class<? extends EventHandler> eventHandlerClass);

    void put(HandlerScope handlerScope, Class<? extends EventHandler> eventHandlerClass);

    void put(Class<? extends Event> eventClass, EventHandler eventHandler);

    void put(HandlerScope handlerScope, EventHandler eventHandler);

    void override(Class<? extends Event> eventClass, Class<? extends EventHandler> from, Class<? extends EventHandler> to);

    void override(HandlerScope handlerScope, Class<? extends EventHandler> from, Class<? extends EventHandler> to);

    void override(Class<? extends Event> eventClass, EventHandler from, EventHandler to);

    void override(HandlerScope handlerScope, EventHandler from, EventHandler to);

    void remove(Class<? extends Event> eventClass);

    void remove(HandlerScope handlerScope);

    boolean contains(Class<? extends Event> eventClass);

    boolean contains(HandlerScope handlerScope);
}
