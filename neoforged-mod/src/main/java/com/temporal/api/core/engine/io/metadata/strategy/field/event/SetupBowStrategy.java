package com.temporal.api.core.engine.io.metadata.strategy.field.event;

import com.temporal.api.core.engine.event.handler.FMLClientSetupEventHandler;
import com.temporal.api.core.engine.event.handler.FovModifierEventHandler;
import com.temporal.api.core.engine.io.metadata.annotation.event.SetupBow;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import net.neoforged.neoforge.registries.DeferredItem;

import java.lang.reflect.Field;

public class SetupBowStrategy implements FieldAnnotationStrategy<SetupBow> {
    @Override
    public void execute(Field field, Object object, SetupBow annotation) throws Exception {
        DeferredItem<?> bowItem = (DeferredItem<?>) field.get(object);
        FovModifierEventHandler.BOWS.add(bowItem);
        FMLClientSetupEventHandler.BOWS.add(bowItem);
    }

    @Override
    public Class<? extends SetupBow> getAnnotationClass() {
        return SetupBow.class;
    }
}
