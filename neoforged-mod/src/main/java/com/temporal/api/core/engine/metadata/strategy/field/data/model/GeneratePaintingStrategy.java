package com.temporal.api.core.engine.metadata.strategy.field.data.model;

import com.temporal.api.core.engine.event.data.painting.ApiPaintingVariantProvider;
import com.temporal.api.core.engine.event.data.painting.PaintingVariantDescription;
import com.temporal.api.core.engine.event.data.tag.PaintingVariantTagsProvider;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.model.GeneratePainting;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.MapUtils;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GeneratePaintingStrategy implements FieldAnnotationStrategy<GeneratePainting> {
    public static final String MINECRAFT_PLACEABLES_TAG = "minecraft:placeables";

    @Override
    public void execute(Field field, Object object, GeneratePainting annotation) throws Exception {
        ResourceKey<PaintingVariant> paintingVariant = ReflectionUtils.getFieldValue(field, object);
        PaintingVariantDescription paintingVariantDescription = new PaintingVariantDescription(paintingVariant, annotation.width(), annotation.height());
        ApiPaintingVariantProvider.PAINTINGS.add(paintingVariantDescription);
        MapUtils.putToListMap(PaintingVariantTagsProvider.TAG_GENERATION_DESCRIPTIONS, MINECRAFT_PLACEABLES_TAG, paintingVariant);
    }

    @Override
    public Class<GeneratePainting> getAnnotationClass() {
        return GeneratePainting.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
