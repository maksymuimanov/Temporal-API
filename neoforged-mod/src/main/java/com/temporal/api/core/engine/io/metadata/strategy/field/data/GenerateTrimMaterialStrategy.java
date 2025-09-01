package com.temporal.api.core.engine.io.metadata.strategy.field.data;

import com.temporal.api.core.engine.io.metadata.annotation.data.GenerateTrimMaterial;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.trim.material.ApiTrimMaterialProvider;
import com.temporal.api.core.event.data.trim.material.TrimMaterialDescription;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.armortrim.TrimMaterial;

import java.lang.reflect.Field;

public class GenerateTrimMaterialStrategy implements FieldAnnotationStrategy<GenerateTrimMaterial> {
    @Override
    public void execute(Field field, Object object, GenerateTrimMaterial annotation) throws Exception {
        ResourceKey<TrimMaterial> trimMaterial = (ResourceKey<TrimMaterial>) field.get(object);
        TrimMaterialDescription descriptionHolder = new TrimMaterialDescription(annotation.itemId(), annotation.color(), annotation.itemModelIndex());
        ApiTrimMaterialProvider.TRIM_MATERIALS.put(trimMaterial, descriptionHolder);
    }

    @Override
    public Class<? extends GenerateTrimMaterial> getAnnotationClass() {
        return GenerateTrimMaterial.class;
    }
}
