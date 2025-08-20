package com.temporal.api.core.engine.io.context;

import net.neoforged.bus.EventBus;
import net.neoforged.bus.api.IEventBus;

import java.util.List;

public class EventBusPoolInitializer implements ObjectPoolInitializer {
    @Override
    public void initialize(List<?> externalObjects) {
        if (externalObjects == null || externalObjects.isEmpty()) return;
        ObjectPool objectPool = InjectionPool.getInstance();
        externalObjects.stream()
                .filter(o -> o instanceof IEventBus)
                .map(o -> (EventBus)o)
                .forEach(objectPool::putObject);
    }
}
