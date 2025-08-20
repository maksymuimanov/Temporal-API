package com.temporal.api.core.engine.event.adapter;

import net.neoforged.bus.api.Event;

import java.util.Map;

public interface EventAdapter<T extends Event, R> {
    R adapt(T t);

    R adapt(T t, boolean condition);

    EventAdapter<T, R> adapt(T t, AdapterInitializer... initializers);

    EventAdapter<T, R> adapt(T t, boolean condition, AdapterInitializer... initializers);

    EventAdapter<T, R> adapt(T t, Map<AdapterInitializer, Boolean> initializers);

    EventAdapter<T, R> adapt(T t, boolean condition, Map<AdapterInitializer, Boolean> initializers);
}
