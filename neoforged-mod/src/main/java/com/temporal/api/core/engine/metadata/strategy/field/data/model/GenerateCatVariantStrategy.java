package com.temporal.api.core.engine.metadata.strategy.field.data.model;

import com.temporal.api.core.engine.event.data.cat.ApiCatVariantProvider;
import com.temporal.api.core.engine.event.data.cat.CatVariantDescription;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.model.GenerateCatVariant;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.CatVariant;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateCatVariantStrategy implements FieldAnnotationStrategy<GenerateCatVariant> {
    @Override
    public void execute(Field field, Object object, GenerateCatVariant annotation) throws Exception {
        ResourceKey<CatVariant> variantResourceKey = (ResourceKey<CatVariant>) field.get(object);
        ApiCatVariantProvider.VARIANTS.add(new CatVariantDescription(variantResourceKey));
    }

    @Override
    public Class<GenerateCatVariant> getAnnotationClass() {
        return GenerateCatVariant.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
