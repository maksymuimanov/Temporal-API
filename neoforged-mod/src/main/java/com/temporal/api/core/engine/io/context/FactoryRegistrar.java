package com.temporal.api.core.engine.io.context;

import net.neoforged.bus.api.IEventBus;

public interface FactoryRegistrar {
    void registerFactories(IEventBus eventBus);
}