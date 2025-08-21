package com.temporal.api.core.engine.io.metadata.strategy.field.injection;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.engine.io.metadata.annotation.injection.RegisterFactory;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.registry.factory.common.ObjectFactory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;

import java.lang.reflect.Field;

public class RegisterFactoryFieldStrategy implements FieldAnnotationStrategy<RegisterFactory> {
    @Override
    public void execute(Field field, Object object, RegisterFactory annotation) throws Exception {
        String modCondition = annotation.mandatoryMod();
        if (modCondition.isBlank() || ModList.get().isLoaded(modCondition)) {
            ObjectFactory<?> objectFactory = (ObjectFactory<?>) field.get(object);
            IEventBus eventBus = InjectionPool.getFromInstance(IEventBus.class);
            objectFactory.register(eventBus);
        }
    }

    @Override
    public Class<? extends RegisterFactory> getAnnotationClass() {
        return RegisterFactory.class;
    }
}
