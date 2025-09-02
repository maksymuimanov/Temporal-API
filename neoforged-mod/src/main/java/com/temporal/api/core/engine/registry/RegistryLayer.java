package com.temporal.api.core.engine.registry;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.EngineLayer;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.context.ObjectPool;
import com.temporal.api.core.engine.registry.registrar.FactoryRegistrar;
import net.neoforged.bus.api.IEventBus;

import java.util.List;

public class RegistryLayer implements EngineLayer {
    private List<FactoryRegistrar> factoryRegistrars;

    @Override
    public void processAllTasks() {
        ObjectPool objectPool = InjectionPool.getInstance();
        IEventBus eventBus = objectPool.getObject(IEventBus.class);
        factoryRegistrars.forEach(factoryRegistrar -> {
            ApiMod.LOGGER.debug("Registering factories with {}", factoryRegistrar.getClass().getName());
            factoryRegistrar.registerFactories(eventBus);
        });
    }

    public void setFactoryRegistrars(List<FactoryRegistrar> factoryRegistrars) {
        this.factoryRegistrars = factoryRegistrars;
    }
}
