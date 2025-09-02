package com.temporal.api.core.engine.setup.initializer;

import com.temporal.api.core.engine.context.ObjectPool;

import java.util.List;

@FunctionalInterface
public interface ObjectPoolInitializer {
    void initialize(ObjectPool objectPool, List<?> externalObjects);
}
