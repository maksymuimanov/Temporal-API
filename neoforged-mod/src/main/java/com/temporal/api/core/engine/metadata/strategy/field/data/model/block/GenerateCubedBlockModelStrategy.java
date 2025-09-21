package com.temporal.api.core.engine.metadata.strategy.field.data.model.block;

import com.temporal.api.core.engine.event.data.model.block.BlockModelDescriptionContainer;
import com.temporal.api.core.engine.event.data.model.block.spec.BlockModelSpec;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.model.block.GenerateCubedBlockModel;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateCubedBlockModelStrategy implements FieldAnnotationStrategy<GenerateCubedBlockModel> {
    @Override
    public void execute(Field field, Object object, GenerateCubedBlockModel annotation) throws Exception {
        Holder<? extends Block> holder = (Holder<? extends Block>) field.get(object);
        BlockModelSpec spec = new BlockModelSpec(holder, annotation.renderType());
        BlockModelDescriptionContainer.CUBED_BLOCKS.add(spec);
    }

    @Override
    public Class<GenerateCubedBlockModel> getAnnotationClass() {
        return GenerateCubedBlockModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
