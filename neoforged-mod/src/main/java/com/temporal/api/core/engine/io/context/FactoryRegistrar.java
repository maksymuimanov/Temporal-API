package com.temporal.api.core.engine.io.context;

import com.temporal.api.core.registry.factory.common.ObjectFactory;

public interface FactoryRegistrar {
    <T, F extends ObjectFactory<T>> void registerFactories(F factory);

    boolean isFactoryRegistered(Class<? extends ObjectFactory<?>> factory);
}