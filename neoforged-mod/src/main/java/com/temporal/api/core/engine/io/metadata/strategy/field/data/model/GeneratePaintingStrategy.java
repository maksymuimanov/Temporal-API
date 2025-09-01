package com.temporal.api.core.engine.io.metadata.strategy.field.data.model;

import com.temporal.api.core.engine.io.metadata.annotation.data.model.GeneratePainting;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.file.PlaceablePaintingProvider;
import com.temporal.api.core.event.data.painting.ApiPaintingVariantProvider;
import com.temporal.api.core.event.data.painting.PaintingVariantDescription;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

import java.lang.reflect.Field;

public class GeneratePaintingStrategy implements FieldAnnotationStrategy<GeneratePainting> {
    @Override
    public void execute(Field field, Object object, GeneratePainting annotation) throws Exception {
        ResourceKey<PaintingVariant> paintingVariant = (ResourceKey<PaintingVariant>) field.get(object);
        PaintingVariantDescription paintingVariantDescription = new PaintingVariantDescription(paintingVariant, annotation.width(), annotation.height());
        ApiPaintingVariantProvider.PAINTINGS.add(paintingVariantDescription);
        PlaceablePaintingProvider.PLACEABLES.add(paintingVariant);
    }

    @Override
    public Class<? extends GeneratePainting> getAnnotationClass() {
        return GeneratePainting.class;
    }
}
