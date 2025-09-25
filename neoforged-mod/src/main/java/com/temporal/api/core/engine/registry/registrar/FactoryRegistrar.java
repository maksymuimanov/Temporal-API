package com.temporal.api.core.engine.registry.registrar;

import net.neoforged.bus.api.IEventBus;

public interface FactoryRegistrar {
    void registerFactories(IEventBus eventBus);
}