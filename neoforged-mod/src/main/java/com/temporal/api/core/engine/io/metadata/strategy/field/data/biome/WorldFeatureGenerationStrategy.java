package com.temporal.api.core.engine.io.metadata.strategy.field.data.biome;

import com.temporal.api.core.engine.io.metadata.annotation.data.biome.WorldFeatureGeneration;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.biome.GenerationDescriptionContainer;
import com.temporal.api.core.event.data.biome.configuration.ConfiguredFeatureDefinition;
import com.temporal.api.core.event.data.biome.modifier.BiomeModifierDefinition;
import com.temporal.api.core.event.data.biome.placement.PlacedFeatureDefinition;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class WorldFeatureGenerationStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        WorldFeatureGeneration worldFeatureGeneration = field.getDeclaredAnnotation(WorldFeatureGeneration.class);
        ConfiguredFeatureDefinition<?, ?> configuredFeatureDefinition = worldFeatureGeneration.configuration()
                .getDeclaredConstructor()
                .newInstance();
        PlacedFeatureDefinition<?> placedFeatureDefinition = worldFeatureGeneration.placement()
                .getDeclaredConstructor()
                .newInstance();
        BiomeModifierDefinition<?> biomeModifierDefinition = worldFeatureGeneration.biomeModifier()
                .getDeclaredConstructor()
                .newInstance();
        GenerationDescriptionContainer.CUSTOM_CONFIGURED_FEATURES.add(configuredFeatureDefinition);
        GenerationDescriptionContainer.CUSTOM_PLACED_FEATURES.add(placedFeatureDefinition);
        GenerationDescriptionContainer.CUSTOM_BIOME_MODIFIERS.add(biomeModifierDefinition);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return WorldFeatureGeneration.class;
    }
}
