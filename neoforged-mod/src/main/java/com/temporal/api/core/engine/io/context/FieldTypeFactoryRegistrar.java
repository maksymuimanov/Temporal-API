package com.temporal.api.core.engine.io.context;

import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.registry.factory.ObjectFactory;
import com.temporal.api.core.util.ReflectionUtils;
import net.neoforged.bus.api.IEventBus;

public class FieldTypeFactoryRegistrar implements FactoryRegistrar {
    @Override
    public void registerFactories(IEventBus eventBus) {
        IOLayer.NEO_MOD.getClasses()
                .stream()
                .filter(ReflectionUtils::isFactoryPresent)
                .forEach(clazz -> {
                    ReflectionUtils.getStaticFieldTypeStream(clazz,
                            field -> ObjectFactory.class.isAssignableFrom(field.getType()),
                            type -> (ObjectFactory<?>) InjectionPool.getFromInstance(type))
                            .forEach(factory -> factory.register(eventBus, clazz));
                });
    }
}
