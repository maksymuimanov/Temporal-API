package com.temporal.api.core.engine.metadata.strategy.field.data.tag;

import com.temporal.api.core.engine.event.data.tag.FluidTagsProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.tag.AddFluidTag;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.MapUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.material.Fluid;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class AddFluidTagStrategy implements FieldAnnotationStrategy<AddFluidTag> {
    @Override
    public void execute(Field field, Object object, AddFluidTag annotation) throws Exception {
        Holder<? extends Fluid> fluid = (Holder<? extends Fluid>) field.get(object);
        for (String tag : annotation.value()) {
            MapUtils.putToListMap(FluidTagsProvider.TAG_GENERATION_DESCRIPTIONS, tag, fluid);
        }
    }

    @Override
    public Class<AddFluidTag> getAnnotationClass() {
        return AddFluidTag.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
