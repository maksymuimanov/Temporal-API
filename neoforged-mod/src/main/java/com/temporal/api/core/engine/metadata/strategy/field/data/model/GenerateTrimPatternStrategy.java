package com.temporal.api.core.engine.metadata.strategy.field.data.model;

import com.temporal.api.core.engine.event.data.trim.pattern.ApiTrimPatternProvider;
import com.temporal.api.core.engine.event.data.trim.pattern.TrimPatternDescription;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.model.GenerateTrimPattern;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.armortrim.TrimPattern;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateTrimPatternStrategy implements FieldAnnotationStrategy<GenerateTrimPattern> {
    @Override
    public void execute(Field field, Object object, GenerateTrimPattern annotation) throws Exception {
        ResourceKey<TrimPattern> trimPattern = (ResourceKey<TrimPattern>) field.get(object);
        TrimPatternDescription descriptionHolder = new TrimPatternDescription(annotation.itemId(), annotation.decal());
        ApiTrimPatternProvider.TRIM_PATTERNS.put(trimPattern, descriptionHolder);
    }

    @Override
    public Class<? extends GenerateTrimPattern> getAnnotationClass() {
        return GenerateTrimPattern.class;
    }
}
