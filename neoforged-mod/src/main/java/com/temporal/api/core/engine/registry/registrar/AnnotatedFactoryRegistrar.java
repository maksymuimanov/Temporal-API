package com.temporal.api.core.engine.registry.registrar;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.metadata.annotation.injection.RegisterFactory;
import com.temporal.api.core.engine.registry.factory.ObjectFactory;
import com.temporal.api.core.util.ReflectionUtils;
import net.neoforged.bus.api.IEventBus;

public class AnnotatedFactoryRegistrar implements FactoryRegistrar {
    @Override
    public void registerFactories(IEventBus eventBus) {
        ModContext.NEO_MOD.getClasses()
                .stream()
                .filter(ReflectionUtils::isFactoryPresent)
                .forEach(clazz -> {
                    ReflectionUtils.getStaticFieldTypeStream(clazz,
                                    field -> field.isAnnotationPresent(RegisterFactory.class),
                                    type -> (ObjectFactory<?>) InjectionPool.getFromInstance(type))
                            .forEach(factory -> factory.register(eventBus, clazz));
                });
    }
}
