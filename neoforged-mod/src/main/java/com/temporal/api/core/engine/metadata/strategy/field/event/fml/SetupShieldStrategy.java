package com.temporal.api.core.engine.metadata.strategy.field.event.fml;

import com.temporal.api.core.engine.event.handler.FMLClientSetupEventHandler;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.event.fml.SetupShield;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_EVENT_FML)
public class SetupShieldStrategy implements FieldAnnotationStrategy<SetupShield> {
    @Override
    public void execute(Field field, Object object, SetupShield annotation) throws Exception {
        Holder<? extends Item> bowItem = (Holder<? extends Item>) field.get(object);
        FMLClientSetupEventHandler.SHIELDS.add(bowItem);
    }

    @Override
    public Class<? extends SetupShield> getAnnotationClass() {
        return SetupShield.class;
    }
}
