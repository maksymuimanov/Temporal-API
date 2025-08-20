package com.temporal.api.core.engine.io.context;

import net.neoforged.fml.ModContainer;

import java.util.List;

public class ModContainerPoolInitializer implements ObjectPoolInitializer {
    @Override
    public void initialize(List<?> externalObjects) {
        if (externalObjects == null || externalObjects.isEmpty()) return;
        ObjectPool objectPool = InjectionPool.getInstance();
        externalObjects.stream()
                .filter(o -> o instanceof ModContainer)
                .map(o -> (ModContainer)o)
                .forEach(objectPool::putObject);
    }
}
