package com.temporal.api.core.engine.event.adapter;

import net.neoforged.bus.api.Event;

import java.util.Map;

public abstract class AbstractEventAdapter<T extends Event, R> implements EventAdapter<T, R> {
    @Override
    public R adapt(T t) {
        return this.adapt(t, true);
    }

    @Override
    public EventAdapter<T, R> adapt(T t, AdapterInitializer... initializers) {
        return this.adapt(t, true, initializers);
    }

    @Override
    public EventAdapter<T, R> adapt(T t, Map<AdapterInitializer, Boolean> initializers) {
        return this.adapt(t, true, initializers);
    }
}
