package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.registry.TemporalRegister;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public abstract class AbstractObjectFactory<R> implements ObjectFactory<R> {
    private final TemporalRegister<R> registry;

    public AbstractObjectFactory(TemporalRegister<R> registry) {
        this.registry = registry;
    }

    @Override
    public <T extends R> DeferredHolder<R, T> create(String name, Supplier<T> supplier) {
        return this.getRegistry().register(name, supplier);
    }

    @Override
    public void register(IEventBus eventBus, Class<?>... containers) {
        this.getRegistry().register(eventBus, containers);
    }

    @Override
    public TemporalRegister<R> getRegistry() {
        return registry;
    }
}
