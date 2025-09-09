package com.temporal.api.core.engine.event.pool;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.event.handler.EventHandler;
import com.temporal.api.core.util.MapUtils;
import net.neoforged.bus.api.Event;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class SimpleEventHandlerPool implements EventHandlerPool {
    private final Map<Class<? extends Event>, List<EventHandler>> eventHandlers;

    public SimpleEventHandlerPool() {
        this.eventHandlers = new LinkedHashMap<>();
    }

    @Override
    public List<EventHandler> getAll(Collection<Class<? extends Event>> eventClasses) {
        return this.eventHandlers.entrySet()
                .stream()
                .filter(entry -> eventClasses.contains(entry.getKey()))
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toList());

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<EventHandler> getAll(Class<? extends Event> eventClass, Class<? extends Event>... eventClasses) {
        return this.eventHandlers.entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(eventClass) || Arrays.asList(eventClasses).contains(eventClass))
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toList());
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E extends EventHandler> List<E> get(Class<? extends Event> eventClass) {
        return (List<E>) this.eventHandlers.get(eventClass);
    }

    @Override
    public void put(Class<? extends Event> eventClass, Class<? extends EventHandler> eventHandlerClass) {
        try {
            Constructor<? extends EventHandler> constructor = eventHandlerClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            EventHandler eventHandler = constructor.newInstance();
            this.put(eventClass, eventHandler);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <E extends EventHandler> void put(Class<? extends Event> eventClass, E eventHandler) {
        MapUtils.putToListMap(this.eventHandlers, eventClass, eventHandler);
    }

    @Override
    public void remove(Class<? extends Event> eventClass) {
        this.eventHandlers.remove(eventClass);
    }

    @Override
    public boolean contains(Class<? extends Event> eventClass) {
        return this.eventHandlers.containsKey(eventClass);
    }

    @Override
    @NotNull
    public Iterator<EventHandler> iterator() {
        return eventHandlers.values().stream().flatMap(Collection::stream).iterator();
    }

    public static SimpleEventHandlerPool getInstance() {
        return InjectionPool.getFromInstance(SimpleEventHandlerPool.class);
    }
}
