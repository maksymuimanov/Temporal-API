package com.temporal.api.core.engine.event.pool;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.event.handler.EventHandler;
import com.temporal.api.core.util.MapUtils;
import com.temporal.api.core.util.ReflectionUtils;
import net.neoforged.bus.api.Event;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class SimpleHandlerPool implements HandlerPool {
    private final Map<HandlerScope, List<EventHandler>> eventHandlers;

    public SimpleHandlerPool() {
        this.eventHandlers = new LinkedHashMap<>();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<EventHandler> getAll(Class<? extends Event> eventClass, Class<? extends Event>... eventClasses) {
        List<Class<? extends Event>> list = new ArrayList<>();
        list.add(eventClass);
        list.addAll(Arrays.asList(eventClasses));
        return this.getAll(list);
    }

    @Override
    public List<EventHandler> getAll(Collection<Class<? extends Event>> eventClasses) {
        return this.eventHandlers.entrySet()
                .stream()
                .filter(entry -> eventClasses.contains(entry.getKey().eventClass()))
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toList());

    }

    @Override
    public List<EventHandler> get(Class<? extends Event> eventClass) {
        HandlerScope handlerScope = new HandlerScope(eventClass);
        return this.get(handlerScope);
    }

    @Override
    public List<EventHandler> get(HandlerScope handlerScope) {
        return this.eventHandlers.get(handlerScope);
    }

    @Override
    public void put(Class<? extends Event> eventClass, Class<? extends EventHandler> eventHandlerClass) {
        HandlerScope handlerScope = new HandlerScope(eventClass);
        this.put(handlerScope, eventHandlerClass);
    }

    @Override
    public void put(HandlerScope handlerScope, Class<? extends EventHandler> eventHandlerClass) {
        EventHandler eventHandler = ReflectionUtils.createObject(eventHandlerClass);
        this.put(handlerScope, eventHandler);
    }

    @Override
    public  void put(Class<? extends Event> eventClass, EventHandler eventHandler) {
        HandlerScope handlerScope = new HandlerScope(eventClass);
        this.put(handlerScope, eventHandler);
    }

    @Override
    public void put(HandlerScope handlerScope, EventHandler eventHandler) {
        MapUtils.putToSortedListMap(this.eventHandlers, handlerScope, eventHandler, EventHandler::compareTo);
    }

    @Override
    public void override(Class<? extends Event> eventClass, Class<? extends EventHandler> from, Class<? extends EventHandler> to) {
        HandlerScope handlerScope = new HandlerScope(eventClass);
        this.override(handlerScope, from, to);
    }

    @Override
    public void override(HandlerScope handlerScope, Class<? extends EventHandler> from, Class<? extends EventHandler> to) {
        EventHandler eventHandlerFrom = ReflectionUtils.createObject(from);
        EventHandler eventHandlerTo = ReflectionUtils.createObject(to);
        this.override(handlerScope, eventHandlerFrom, eventHandlerTo);
    }

    @Override
    public void override(Class<? extends Event> eventClass, EventHandler from, EventHandler to) {
        HandlerScope handlerScope = new HandlerScope(eventClass);
        this.override(handlerScope, from, to);
    }

    @Override
    public void override(HandlerScope handlerScope, EventHandler from, EventHandler to) {
        List<EventHandler> eventHandlers = this.get(handlerScope);
        eventHandlers.parallelStream()
                .filter(eventHandler -> eventHandler.getClass().equals(from.getClass()))
                .findAny()
                .ifPresent(eventHandler -> {
                    eventHandlers.remove(eventHandler);
                    eventHandlers.add(to);
                    eventHandlers.sort(EventHandler::compareTo);
                });
    }

    @Override
    public void remove(Class<? extends Event> eventClass) {
        HandlerScope handlerScope = new HandlerScope(eventClass);
        this.remove(handlerScope);
    }

    @Override
    public void remove(HandlerScope handlerScope) {
        this.eventHandlers.remove(handlerScope);
    }

    @Override
    public boolean contains(Class<? extends Event> eventClass) {
        HandlerScope handlerScope = new HandlerScope(eventClass);
        return this.contains(handlerScope);
    }

    @Override
    public boolean contains(HandlerScope handlerScope) {
        return this.eventHandlers.containsKey(handlerScope);
    }

    @Override
    @NotNull
    public Iterator<EventHandler> iterator() {
        return eventHandlers.values().stream().flatMap(Collection::stream).iterator();
    }

    public static SimpleHandlerPool getInstance() {
        return InjectionPool.getFromInstance(SimpleHandlerPool.class);
    }
}
