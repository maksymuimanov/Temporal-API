package com.temporal.api.core.engine.metadata.strategy.field.data.model.block;

import com.temporal.api.core.engine.event.data.model.block.BlockModelContainer;
import com.temporal.api.core.engine.event.data.model.block.spec.DependantBlockModelSpec;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.model.block.GenerateFlowerBlockModel;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateFlowerBlockModelStrategy implements FieldAnnotationStrategy<GenerateFlowerBlockModel> {
    @Override
    public void execute(Field field, Object object, GenerateFlowerBlockModel annotation) throws Exception {
        Holder<? extends Block> holder = (Holder<? extends Block>) field.get(object);
        DependantBlockModelSpec spec = new DependantBlockModelSpec(holder, annotation.renderType(), annotation.pottedFlowerId());
        BlockModelContainer.FLOWER_BLOCKS.add(spec);
    }

    @Override
    public Class<GenerateFlowerBlockModel> getAnnotationClass() {
        return GenerateFlowerBlockModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
