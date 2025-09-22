package com.temporal.api.core.engine.metadata.strategy.field.data.model.block;

import com.temporal.api.core.engine.event.data.model.block.BlockModelContainer;
import com.temporal.api.core.engine.event.data.model.block.spec.DependantBlockModelSpec;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.model.block.GeneratePressurePlateBlockModel;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GeneratePressurePlateBlockModelStrategy implements FieldAnnotationStrategy<GeneratePressurePlateBlockModel> {
    @Override
    public void execute(Field field, Object object, GeneratePressurePlateBlockModel annotation) throws Exception {
        Holder<? extends Block> holder = (Holder<? extends Block>) field.get(object);
        DependantBlockModelSpec spec = new DependantBlockModelSpec(holder, annotation.parentBlockId());
        BlockModelContainer.PRESSURE_PLATES.add(spec);
    }

    @Override
    public Class<GeneratePressurePlateBlockModel> getAnnotationClass() {
        return GeneratePressurePlateBlockModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
