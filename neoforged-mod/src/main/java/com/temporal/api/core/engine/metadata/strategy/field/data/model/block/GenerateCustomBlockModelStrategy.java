package com.temporal.api.core.engine.metadata.strategy.field.data.model.block;

import com.temporal.api.core.engine.event.data.model.block.BlockModelContainer;
import com.temporal.api.core.engine.event.data.model.block.spec.CustomBlockModelSpec;
import com.temporal.api.core.engine.event.data.model.block.strategy.BlockModelProviderStrategy;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.model.block.GenerateCustomBlockModel;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;
import java.util.List;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateCustomBlockModelStrategy implements FieldAnnotationStrategy<GenerateCustomBlockModel> {
    @Override
    @SuppressWarnings("unchecked")
    public void execute(Field field, Object object, GenerateCustomBlockModel annotation) throws Exception {
        Holder<? extends Block> holder = (Holder<? extends Block>) field.get(object);
        List<String> additionalData = List.of(annotation.additionalData());
        CustomBlockModelSpec spec = new CustomBlockModelSpec(holder, annotation.renderType(), additionalData);
        BlockModelProviderStrategy<CustomBlockModelSpec> providerStrategy = ReflectionUtils.createObject(annotation.strategy());
        BlockModelContainer.CUSTOM_MODELS.put(spec, providerStrategy);
    }

    @Override
    public Class<GenerateCustomBlockModel> getAnnotationClass() {
        return GenerateCustomBlockModel.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
