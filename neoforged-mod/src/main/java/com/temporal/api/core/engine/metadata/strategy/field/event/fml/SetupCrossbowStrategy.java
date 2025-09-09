package com.temporal.api.core.engine.metadata.strategy.field.event.fml;

import com.temporal.api.core.engine.event.handler.FMLClientSetupEventHandler;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.event.fml.SetupCrossbow;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_EVENT_FML)
public class SetupCrossbowStrategy implements FieldAnnotationStrategy<SetupCrossbow> {
    @Override
    public void execute(Field field, Object object, SetupCrossbow annotation) throws Exception {
        Holder<? extends Item> crossbowItem = (Holder<? extends Item>) field.get(object);
        FMLClientSetupEventHandler.CROSSBOWS.add(crossbowItem);
    }

    @Override
    public Class<? extends SetupCrossbow> getAnnotationClass() {
        return SetupCrossbow.class;
    }
}
