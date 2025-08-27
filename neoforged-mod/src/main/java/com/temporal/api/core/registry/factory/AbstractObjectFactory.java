package com.temporal.api.core.registry.factory;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public abstract class AbstractObjectFactory<R> implements ObjectFactory<R> {
    private final DeferredRegister<R> registry;

    public AbstractObjectFactory(DeferredRegister<R> registry) {
        this.registry = registry;
    }

    @Override
    public <T extends R> DeferredHolder<R, T> create(String name, Supplier<T> supplier) {
        return this.getRegistry().register(name, supplier);
    }

    @Override
    public void register(IEventBus eventBus) {
        this.getRegistry().register(eventBus);
    }

    @Override
    public DeferredRegister<R> getRegistry() {
        return registry;
    }
}
