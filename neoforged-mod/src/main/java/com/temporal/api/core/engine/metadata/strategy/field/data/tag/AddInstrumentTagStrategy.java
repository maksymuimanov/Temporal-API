package com.temporal.api.core.engine.metadata.strategy.field.data.tag;

import com.temporal.api.core.engine.event.data.tag.InstrumentTagsProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.tag.AddInstrumentTag;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.MapUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Instrument;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class AddInstrumentTagStrategy implements FieldAnnotationStrategy<AddInstrumentTag> {
    @Override
    public void execute(Field field, Object object, AddInstrumentTag annotation) throws Exception {
        ResourceKey<Instrument> instrument = (ResourceKey<Instrument>) field.get(object);
        for (String tag : annotation.value()) {
            MapUtils.putToListMap(InstrumentTagsProvider.TAG_GENERATION_DESCRIPTIONS, tag, instrument);
        }
    }

    @Override
    public Class<AddInstrumentTag> getAnnotationClass() {
        return AddInstrumentTag.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
