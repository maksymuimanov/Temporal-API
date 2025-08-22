package com.temporal.api.core.engine.io.metadata.strategy.field.event;

import com.temporal.api.core.engine.event.handler.FMLClientSetupEventHandler;
import com.temporal.api.core.engine.io.metadata.annotation.event.SetupShield;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import net.neoforged.neoforge.registries.DeferredItem;

import java.lang.reflect.Field;

public class SetupShieldStrategy implements FieldAnnotationStrategy<SetupShield> {
    @Override
    public void execute(Field field, Object object, SetupShield annotation) throws Exception {
        DeferredItem<?> bowItem = (DeferredItem<?>) field.get(object);
        FMLClientSetupEventHandler.SHIELDS.add(bowItem);
    }

    @Override
    public Class<? extends SetupShield> getAnnotationClass() {
        return SetupShield.class;
    }
}
