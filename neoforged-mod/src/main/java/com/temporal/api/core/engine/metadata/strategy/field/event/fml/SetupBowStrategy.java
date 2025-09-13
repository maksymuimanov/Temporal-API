package com.temporal.api.core.engine.metadata.strategy.field.event.fml;

import com.temporal.api.core.engine.event.handler.FMLClientSetupEventHandler;
import com.temporal.api.core.engine.event.handler.FovModifierEventHandler;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.event.fml.SetupBow;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_EVENT_FML)
public class SetupBowStrategy implements FieldAnnotationStrategy<SetupBow> {
    @Override
    public void execute(Field field, Object object, SetupBow annotation) throws Exception {
        Holder<? extends Item> bowItem = (Holder<? extends Item>) field.get(object);
        FovModifierEventHandler.BOWS.add(bowItem);
        FMLClientSetupEventHandler.BOWS.add(bowItem);
    }

    @Override
    public Class<? extends SetupBow> getAnnotationClass() {
        return SetupBow.class;
    }

    @Override
    public AnnotationExecutor<? extends AnnotationStrategy<Field, ?>> getExecutor() {
        return MetadataLayer.STATIC_FIELD_EXECUTOR;
    }
}
