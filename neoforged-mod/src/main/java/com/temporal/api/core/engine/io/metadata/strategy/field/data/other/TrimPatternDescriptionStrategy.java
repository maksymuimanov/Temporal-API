package com.temporal.api.core.engine.io.metadata.strategy.field.data.other;

import com.temporal.api.core.engine.io.metadata.annotation.data.other.TrimPatternDescription;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.trim.pattern.ApiTrimPatternProvider;
import com.temporal.api.core.event.data.trim.pattern.TrimPatternDescriptionHolder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.armortrim.TrimPattern;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class TrimPatternDescriptionStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        TrimPatternDescription annotation = field.getDeclaredAnnotation(TrimPatternDescription.class);
        ResourceKey<TrimPattern> trimPattern = (ResourceKey<TrimPattern>) field.get(object);
        TrimPatternDescriptionHolder descriptionHolder = new TrimPatternDescriptionHolder(annotation.itemId(), annotation.decal());
        ApiTrimPatternProvider.TRIM_PATTERNS.put(trimPattern, descriptionHolder);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return TrimPatternDescription.class;
    }
}
