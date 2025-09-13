package com.temporal.api.core.engine.initialization.initializer;

import com.temporal.api.core.engine.context.ObjectPool;

import java.util.Collection;
import java.util.List;

@FunctionalInterface
public interface ObjectPoolInitializer {
    void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectPool objectPool);
}
