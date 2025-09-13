package com.temporal.api.core.engine.metadata.strategy.field.data.biome;

import com.temporal.api.core.engine.event.data.biome.GenerationDescriptionContainer;
import com.temporal.api.core.engine.event.data.biome.configuration.ConfiguredFeatureDefinition;
import com.temporal.api.core.engine.event.data.biome.modifier.BiomeModifierDefinition;
import com.temporal.api.core.engine.event.data.biome.placement.PlacedFeatureDefinition;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.data.biome.GenerateWorldFeature;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateWorldFeatureStrategy implements FieldAnnotationStrategy<GenerateWorldFeature> {
    @Override
    public void execute(Field field, Object object, GenerateWorldFeature annotation) throws Exception {
        ConfiguredFeatureDefinition<?, ?> configuredFeatureDefinition = annotation.configuration()
                .getDeclaredConstructor()
                .newInstance();
        PlacedFeatureDefinition<?> placedFeatureDefinition = annotation.placement()
                .getDeclaredConstructor()
                .newInstance();
        BiomeModifierDefinition<?> biomeModifierDefinition = annotation.biomeModifier()
                .getDeclaredConstructor()
                .newInstance();
        GenerationDescriptionContainer.CUSTOM_CONFIGURED_FEATURES.add(configuredFeatureDefinition);
        GenerationDescriptionContainer.CUSTOM_PLACED_FEATURES.add(placedFeatureDefinition);
        GenerationDescriptionContainer.CUSTOM_BIOME_MODIFIERS.add(biomeModifierDefinition);
    }

    @Override
    public Class<? extends GenerateWorldFeature> getAnnotationClass() {
        return GenerateWorldFeature.class;
    }

    @Override
    public AnnotationExecutor<? extends AnnotationStrategy<Field, ?>> getExecutor() {
        return MetadataLayer.STATIC_FIELD_EXECUTOR;
    }
}
