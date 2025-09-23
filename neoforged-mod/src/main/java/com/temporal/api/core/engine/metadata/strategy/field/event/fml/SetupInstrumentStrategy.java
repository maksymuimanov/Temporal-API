package com.temporal.api.core.engine.metadata.strategy.field.event.fml;

import com.temporal.api.core.engine.event.handler.FMLClientSetupEventHandler;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.event.fml.SetupInstrument;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.FMLClientSetupEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_EVENT_FML)
public class SetupInstrumentStrategy implements FieldAnnotationStrategy<SetupInstrument> {
    @Override
    public void execute(Field field, Object object, SetupInstrument annotation) throws Exception {
        Holder<? extends Item> instrument = ReflectionUtils.getFieldValue(field, object);
        FMLClientSetupEventHandler.INSTRUMENTS.add(instrument);
    }

    @Override
    public Class<SetupInstrument> getAnnotationClass() {
        return SetupInstrument.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(FMLClientSetupEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
