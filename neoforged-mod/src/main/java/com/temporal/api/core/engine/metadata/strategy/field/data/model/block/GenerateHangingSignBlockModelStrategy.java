package com.temporal.api.core.engine.metadata.strategy.field.data.model.block;

import com.temporal.api.core.engine.event.data.model.block.BlockModelDescriptionContainer;
import com.temporal.api.core.engine.event.data.model.block.spec.SignBlockModelSpec;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.model.block.GenerateHangingSignBlockModel;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateHangingSignBlockModelStrategy implements FieldAnnotationStrategy<GenerateHangingSignBlockModel> {
    @Override
    public void execute(Field field, Object object, GenerateHangingSignBlockModel annotation) throws Exception {
        Holder<? extends Block> holder = (Holder<? extends Block>) field.get(object);
        SignBlockModelSpec spec = new SignBlockModelSpec(holder, annotation.wallHangingSignBlockId(), annotation.particleTexturePath());
        BlockModelDescriptionContainer.HANGING_SIGNS.add(spec);
    }

    @Override
    public Class<GenerateHangingSignBlockModel> getAnnotationClass() {
        return GenerateHangingSignBlockModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
