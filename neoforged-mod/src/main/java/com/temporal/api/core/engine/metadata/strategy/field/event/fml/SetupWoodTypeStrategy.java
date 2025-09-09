package com.temporal.api.core.engine.metadata.strategy.field.event.fml;

import com.temporal.api.core.engine.event.handler.FMLClientSetupEventHandler;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.event.fml.SetupWoodType;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_EVENT_FML)
public class SetupWoodTypeStrategy implements FieldAnnotationStrategy<SetupWoodType> {
    @Override
    public void execute(Field field, Object object, SetupWoodType annotation) throws Exception {
        WoodType woodType = (WoodType) field.get(object);
        FMLClientSetupEventHandler.WOOD_TYPES.add(woodType);
    }

    @Override
    public Class<? extends SetupWoodType> getAnnotationClass() {
        return SetupWoodType.class;
    }
}
