package com.temporal.api.core.engine.initialization.initializer;

import com.temporal.api.core.engine.context.ObjectPool;
import net.neoforged.fml.ModContainer;

import java.util.Collection;
import java.util.List;

public class ModContainerPoolInitializer implements ObjectPoolInitializer {
    @Override
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectPool objectPool) {
        if (externalObjects == null || externalObjects.isEmpty()) return;
        externalObjects.stream()
                .filter(o -> o instanceof ModContainer)
                .map(o -> (ModContainer)o)
                .forEach(objectPool::put);
    }
}
