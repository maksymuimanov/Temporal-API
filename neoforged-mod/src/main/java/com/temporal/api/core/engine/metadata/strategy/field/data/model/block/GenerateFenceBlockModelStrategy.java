package com.temporal.api.core.engine.metadata.strategy.field.data.model.block;

import com.temporal.api.core.engine.event.data.model.block.BlockModelContainer;
import com.temporal.api.core.engine.event.data.model.block.spec.DependantBlockModelSpec;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.model.block.GenerateFenceBlockModel;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateFenceBlockModelStrategy implements FieldAnnotationStrategy<GenerateFenceBlockModel> {
    @Override
    public void execute(Field field, Object object, GenerateFenceBlockModel annotation) throws Exception {
        Holder<? extends Block> holder = (Holder<? extends Block>) field.get(object);
        DependantBlockModelSpec spec = new DependantBlockModelSpec(holder, annotation.renderType(), annotation.fullBlock());
        BlockModelContainer.FENCES.add(spec);
    }

    @Override
    public Class<GenerateFenceBlockModel> getAnnotationClass() {
        return GenerateFenceBlockModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
