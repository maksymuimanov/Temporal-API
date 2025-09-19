package com.temporal.api.core.engine.metadata.strategy.field.data;

import com.temporal.api.core.engine.event.data.instrument.ApiInstrumentProvider;
import com.temporal.api.core.engine.event.data.instrument.InstrumentDescription;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.GenerateInstrument;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Instrument;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateInstrumentStrategy implements FieldAnnotationStrategy<GenerateInstrument> {
    @Override
    public void execute(Field field, Object object, GenerateInstrument annotation) throws Exception {
        ResourceKey<Instrument> instrument = (ResourceKey<Instrument>) field.get(object);
        InstrumentDescription description = new InstrumentDescription(instrument, annotation.soundEvent(), annotation.useDuration(), annotation.range());
        ApiInstrumentProvider.INSTRUMENTS.add(description);
    }

    @Override
    public Class<GenerateInstrument> getAnnotationClass() {
        return GenerateInstrument.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
