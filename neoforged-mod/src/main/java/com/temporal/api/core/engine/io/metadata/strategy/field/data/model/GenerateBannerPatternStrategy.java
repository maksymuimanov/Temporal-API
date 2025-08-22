package com.temporal.api.core.engine.io.metadata.strategy.field.data.model;

import com.temporal.api.core.engine.io.metadata.annotation.data.model.GenerateBannerPattern;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.banner.ApiBannerPatternProvider;
import com.temporal.api.core.event.data.banner.BannerPatternDescriptionHolder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.BannerPattern;

import java.lang.reflect.Field;

public class GenerateBannerPatternStrategy implements FieldAnnotationStrategy<GenerateBannerPattern> {
    @Override
    public void execute(Field field, Object object, GenerateBannerPattern annotation) throws Exception {
        ResourceKey<BannerPattern> patternResourceKey = (ResourceKey<BannerPattern>) field.get(object);
        ApiBannerPatternProvider.PATTERNS.add(new BannerPatternDescriptionHolder(patternResourceKey));
    }

    @Override
    public Class<? extends GenerateBannerPattern> getAnnotationClass() {
        return GenerateBannerPattern.class;
    }
}
