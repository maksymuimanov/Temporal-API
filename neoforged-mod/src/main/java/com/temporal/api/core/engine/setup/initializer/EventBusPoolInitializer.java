package com.temporal.api.core.engine.setup.initializer;

import com.temporal.api.core.engine.context.ObjectPool;
import net.neoforged.bus.EventBus;
import net.neoforged.bus.api.IEventBus;

import java.util.List;

public class EventBusPoolInitializer implements ObjectPoolInitializer {
    @Override
    public void initialize(ObjectPool objectPool, List<?> externalObjects) {
        if (externalObjects == null || externalObjects.isEmpty()) return;
        externalObjects.stream()
                .filter(o -> o instanceof IEventBus)
                .map(o -> (EventBus)o)
                .forEach(objectPool::putObject);
    }
}
