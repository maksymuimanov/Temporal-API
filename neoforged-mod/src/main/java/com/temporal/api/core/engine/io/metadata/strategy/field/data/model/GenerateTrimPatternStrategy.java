package com.temporal.api.core.engine.io.metadata.strategy.field.data.model;

import com.temporal.api.core.engine.io.metadata.annotation.data.model.GenerateTrimPattern;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.trim.pattern.ApiTrimPatternProvider;
import com.temporal.api.core.event.data.trim.pattern.TrimPatternDescriptionHolder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.armortrim.TrimPattern;

import java.lang.reflect.Field;

public class GenerateTrimPatternStrategy implements FieldAnnotationStrategy<GenerateTrimPattern> {
    @Override
    public void execute(Field field, Object object, GenerateTrimPattern annotation) throws Exception {
        ResourceKey<TrimPattern> trimPattern = (ResourceKey<TrimPattern>) field.get(object);
        TrimPatternDescriptionHolder descriptionHolder = new TrimPatternDescriptionHolder(annotation.itemId(), annotation.decal());
        ApiTrimPatternProvider.TRIM_PATTERNS.put(trimPattern, descriptionHolder);
    }

    @Override
    public Class<? extends GenerateTrimPattern> getAnnotationClass() {
        return GenerateTrimPattern.class;
    }
}
