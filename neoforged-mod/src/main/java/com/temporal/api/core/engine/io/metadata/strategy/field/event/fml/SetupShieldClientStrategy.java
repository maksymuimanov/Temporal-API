package com.temporal.api.core.engine.io.metadata.strategy.field.event.fml;

import com.temporal.api.core.engine.event.handler.FMLClientSetupEventHandler;
import com.temporal.api.core.engine.io.metadata.annotation.event.fml.SetupShieldClient;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import net.neoforged.neoforge.registries.DeferredItem;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class SetupShieldClientStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        DeferredItem<?> bowItem = (DeferredItem<?>) field.get(object);
        FMLClientSetupEventHandler.SHIELDS.add(bowItem);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return SetupShieldClient.class;
    }
}
