package com.temporal.api.core.engine.io.metadata.strategy.field.data.other;

import com.temporal.api.core.engine.io.metadata.annotation.data.other.BannerPatternDescription;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.banner.ApiBannerPatternProvider;
import com.temporal.api.core.event.data.banner.BannerPatternDescriptionHolder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.BannerPattern;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class BannerPatternDescriptionStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        ResourceKey<BannerPattern> patternResourceKey = (ResourceKey<BannerPattern>) field.get(object);
        ApiBannerPatternProvider.PATTERNS.add(new BannerPatternDescriptionHolder(patternResourceKey));
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return BannerPatternDescription.class;
    }
}
