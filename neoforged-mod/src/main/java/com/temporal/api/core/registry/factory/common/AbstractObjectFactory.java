package com.temporal.api.core.registry.factory.common;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public abstract class AbstractObjectFactory<R> implements ObjectFactory<R> {
    @Override
    public <T extends R> DeferredHolder<R, T> create(String name, Supplier<T> supplier) {
        return this.getRegistry().register(name, supplier);
    }

    @Override
    public void register(IEventBus eventBus) {
        this.getRegistry().register(eventBus);
    }
}
