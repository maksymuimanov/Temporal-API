package com.temporal.api.core.engine.metadata.strategy.field.data.properties;

import com.temporal.api.core.engine.event.data.map.ApiDataMapProvider;
import com.temporal.api.core.engine.event.data.map.OxidizableDto;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.properties.Oxidizable;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class OxidizableStrategy implements FieldAnnotationStrategy<Oxidizable> {
    @Override
    public void execute(Field field, Object object, Oxidizable annotation) throws Exception {
        Holder<? extends Block> block = (Holder<? extends Block>) field.get(object);
        OxidizableDto oxidizableDto = new OxidizableDto(block, annotation.nextBlockStageId(), annotation.replace());
        ApiDataMapProvider.OXIDIZABLES.add(oxidizableDto);
    }

    @Override
    public Class<Oxidizable> getAnnotationClass() {
        return Oxidizable.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
