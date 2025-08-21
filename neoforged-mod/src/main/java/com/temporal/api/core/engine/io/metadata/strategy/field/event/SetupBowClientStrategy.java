package com.temporal.api.core.engine.io.metadata.strategy.field.event;

import com.temporal.api.core.engine.event.handler.FMLClientSetupEventHandler;
import com.temporal.api.core.engine.event.handler.FovModifierEventHandler;
import com.temporal.api.core.engine.io.metadata.annotation.event.SetupBow;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import net.neoforged.neoforge.registries.DeferredItem;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class SetupBowClientStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        DeferredItem<?> bowItem = (DeferredItem<?>) field.get(object);
        FovModifierEventHandler.BOWS.add(bowItem);
        FMLClientSetupEventHandler.BOWS.add(bowItem);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return SetupBow.class;
    }
}
