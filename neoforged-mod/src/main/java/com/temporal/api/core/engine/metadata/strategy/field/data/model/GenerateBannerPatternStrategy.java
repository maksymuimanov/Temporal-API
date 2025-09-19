package com.temporal.api.core.engine.metadata.strategy.field.data.model;

import com.temporal.api.core.engine.event.data.banner.ApiBannerPatternProvider;
import com.temporal.api.core.engine.event.data.banner.BannerPatternDescription;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.model.GenerateBannerPattern;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventAnnotationProcessor;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.BannerPattern;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateBannerPatternStrategy implements FieldAnnotationStrategy<GenerateBannerPattern> {
    @Override
    public void execute(Field field, Object object, GenerateBannerPattern annotation) throws Exception {
        ResourceKey<BannerPattern> patternResourceKey = (ResourceKey<BannerPattern>) field.get(object);
        ApiBannerPatternProvider.PATTERNS.add(new BannerPatternDescription(patternResourceKey));
    }

    @Override
    public Class<GenerateBannerPattern> getAnnotationClass() {
        return GenerateBannerPattern.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventAnnotationProcessor.NAME);
    }
}
