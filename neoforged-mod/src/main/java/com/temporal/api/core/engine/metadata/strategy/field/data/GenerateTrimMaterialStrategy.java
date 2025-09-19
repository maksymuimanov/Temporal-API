package com.temporal.api.core.engine.metadata.strategy.field.data;

import com.temporal.api.core.engine.event.data.trim.material.ApiTrimMaterialProvider;
import com.temporal.api.core.engine.event.data.trim.material.TrimMaterialDescription;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.GenerateTrimMaterial;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.armortrim.TrimMaterial;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateTrimMaterialStrategy implements FieldAnnotationStrategy<GenerateTrimMaterial> {
    @Override
    public void execute(Field field, Object object, GenerateTrimMaterial annotation) throws Exception {
        ResourceKey<TrimMaterial> trimMaterial = (ResourceKey<TrimMaterial>) field.get(object);
        TrimMaterialDescription descriptionHolder = new TrimMaterialDescription(annotation.itemId(), annotation.color(), annotation.itemModelIndex());
        ApiTrimMaterialProvider.TRIM_MATERIALS.put(trimMaterial, descriptionHolder);
    }

    @Override
    public Class<GenerateTrimMaterial> getAnnotationClass() {
        return GenerateTrimMaterial.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
