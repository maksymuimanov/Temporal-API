package com.temporal.api.core.engine.metadata.strategy.field.data.model;

import com.temporal.api.core.engine.event.data.file.PlaceablePaintingProvider;
import com.temporal.api.core.engine.event.data.painting.ApiPaintingVariantProvider;
import com.temporal.api.core.engine.event.data.painting.PaintingVariantDescription;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.data.model.GeneratePainting;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
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

    @Override
    public AnnotationExecutor<? extends AnnotationStrategy<Field, ?>> getExecutor() {
        return MetadataLayer.STATIC_FIELD_EXECUTOR;
    }
}
