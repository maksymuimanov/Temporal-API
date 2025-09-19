package com.temporal.api.core.engine.metadata.strategy.field.data.model;

import com.temporal.api.core.engine.event.data.frog.ApiFrogVariantProvider;
import com.temporal.api.core.engine.event.data.frog.FrogVariantDescription;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.model.GenerateFrogVariant;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.FrogVariant;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateFrogVariantStrategy implements FieldAnnotationStrategy<GenerateFrogVariant> {
    @Override
    public void execute(Field field, Object object, GenerateFrogVariant annotation) throws Exception {
        ResourceKey<FrogVariant> variantResourceKey = (ResourceKey<FrogVariant>) field.get(object);
        ApiFrogVariantProvider.VARIANTS.add(new FrogVariantDescription(variantResourceKey));
    }

    @Override
    public Class<GenerateFrogVariant> getAnnotationClass() {
        return GenerateFrogVariant.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
