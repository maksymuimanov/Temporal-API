package com.temporal.api.core.engine.io.context;

import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.registry.factory.ObjectFactory;
import com.temporal.api.core.util.IOUtils;
import net.neoforged.bus.api.IEventBus;

public class FieldTypeFactoryRegistrar implements FactoryRegistrar {
    @Override
    public void registerFactories(IEventBus eventBus) {
        IOLayer.NEO_MOD.getClasses()
                .stream()
                .filter(IOUtils::isFactoryPresent)
                .forEach(clazz -> {
                    IOUtils.getStaticFieldStream(clazz,
                                    field -> ObjectFactory.class.isAssignableFrom(field.getType()),
                                    factory -> (ObjectFactory<?>) factory)
                            .forEach(factory -> factory.register(eventBus));
                });
    }
}
