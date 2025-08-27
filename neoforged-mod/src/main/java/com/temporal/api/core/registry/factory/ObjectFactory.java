package com.temporal.api.core.registry.factory;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public interface ObjectFactory<R> {
    <T extends R> DeferredHolder<R, T> create(String name, Supplier<T> supplier);

    void register(IEventBus eventBus);

    DeferredRegister<R> getRegistry();
}
