package com.temporal.api.core.engine.io.context;

import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.engine.io.metadata.annotation.injection.RegisterFactory;
import com.temporal.api.core.registry.factory.ObjectFactory;
import com.temporal.api.core.util.IOUtils;
import net.neoforged.bus.api.IEventBus;

public class AnnotationFactoryRegistrar implements FactoryRegistrar {
    @Override
    public void registerFactories(IEventBus eventBus) {
        IOLayer.NEO_MOD.getClasses()
                .stream()
                .filter(IOUtils::isFactoryPresent)
                .forEach(clazz -> {
                    IOUtils.getStaticFieldTypeStream(clazz,
                                    field -> field.isAnnotationPresent(RegisterFactory.class),
                                    type -> (ObjectFactory<?>) InjectionPool.getFromInstance(type))
                            .forEach(factory -> factory.register(eventBus, clazz));
                });
    }
}
