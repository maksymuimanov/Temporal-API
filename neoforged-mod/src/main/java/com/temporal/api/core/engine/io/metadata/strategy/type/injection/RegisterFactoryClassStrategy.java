package com.temporal.api.core.engine.io.metadata.strategy.type.injection;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.engine.io.metadata.annotation.injection.RegisterFactory;
import com.temporal.api.core.engine.io.metadata.strategy.type.ClassAnnotationStrategy;
import com.temporal.api.core.registry.factory.common.ObjectFactory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;

import java.lang.reflect.Field;

public class RegisterFactoryClassStrategy implements ClassAnnotationStrategy<RegisterFactory> {
    @Override
    public void execute(Class<?> clazz, Object object, RegisterFactory annotation) throws Exception {
        String modCondition = annotation.mandatoryMod();
        if (!modCondition.isBlank() && !ModList.get().isLoaded(modCondition)) return;
        for (Field field : clazz.getDeclaredFields()) {
            if (!(field.get(object) instanceof ObjectFactory<?> objectFactory)) continue;
            IEventBus eventBus = InjectionPool.getFromInstance(IEventBus.class);
            objectFactory.register(eventBus);
        }
    }

    @Override
    public Class<? extends RegisterFactory> getAnnotationClass() {
        return RegisterFactory.class;
    }
}