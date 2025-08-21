package com.temporal.api.core.engine.io.metadata.strategy.field.data.model;

import com.temporal.api.core.engine.io.metadata.annotation.data.model.GeneratePainting;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.json.PlaceablePaintingProvider;
import com.temporal.api.core.event.data.painting.ApiPaintingVariantProvider;
import com.temporal.api.core.event.data.painting.PaintingHolder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class PaintingStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        ResourceKey<PaintingVariant> paintingVariant = (ResourceKey<PaintingVariant>) field.get(object);
        GeneratePainting annotation = field.getDeclaredAnnotation(GeneratePainting.class);
        PaintingHolder paintingHolder = new PaintingHolder(paintingVariant, annotation.width(), annotation.height());
        ApiPaintingVariantProvider.PAINTINGS.add(paintingHolder);
        PlaceablePaintingProvider.PLACEABLES.add(paintingVariant);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return GeneratePainting.class;
    }
}
