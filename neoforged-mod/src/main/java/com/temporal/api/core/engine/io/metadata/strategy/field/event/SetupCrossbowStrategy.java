package com.temporal.api.core.engine.io.metadata.strategy.field.event;

import com.temporal.api.core.engine.event.handler.FMLClientSetupEventHandler;
import com.temporal.api.core.engine.io.metadata.annotation.event.SetupCrossbow;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import net.neoforged.neoforge.registries.DeferredItem;

import java.lang.reflect.Field;

public class SetupCrossbowStrategy implements FieldAnnotationStrategy<SetupCrossbow> {
    @Override
    public void execute(Field field, Object object, SetupCrossbow annotation) throws Exception {
        DeferredItem<?> crossbowItem = (DeferredItem<?>) field.get(object);
        FMLClientSetupEventHandler.CROSSBOWS.add(crossbowItem);
    }

    @Override
    public Class<? extends SetupCrossbow> getAnnotationClass() {
        return SetupCrossbow.class;
    }
}
