package com.temporal.api.core.engine.io.metadata.strategy.field.data.biome;

import com.temporal.api.core.engine.io.metadata.annotation.data.biome.WorldFeatureGeneration;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.biome.GenerationFeaturesDescriptionContainer;
import com.temporal.api.core.event.data.biome.definition.BiomeModifierDefinition;
import com.temporal.api.core.event.data.biome.definition.ConfiguredFeatureDefinition;
import com.temporal.api.core.event.data.biome.definition.PlacedFeatureDefinition;
import com.temporal.api.core.event.data.biome.dto.WorldFeatureDefinitionContainer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class WorldFeatureGenerationStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey = (ResourceKey<ConfiguredFeature<?, ?>>) field.get(object);
        WorldFeatureGeneration worldFeatureGeneration = field.getDeclaredAnnotation(WorldFeatureGeneration.class);
        ConfiguredFeatureDefinition<?> configuredFeatureDefinition = worldFeatureGeneration.configuredFeature()
                .getDeclaredConstructor()
                .newInstance();
        List<PlacedFeatureDefinition> placedFeatureDefinitions = new ArrayList<>(1);
        for (Class<? extends PlacedFeatureDefinition> clazz : worldFeatureGeneration.placedFeatures()) {
            PlacedFeatureDefinition placedFeatureDefinition = clazz.getDeclaredConstructor().newInstance();
            placedFeatureDefinitions.add(placedFeatureDefinition);
        }
        BiomeModifierDefinition biomeModifierDefinition = worldFeatureGeneration.biomeModifier().getDeclaredConstructor().newInstance();
        WorldFeatureDefinitionContainer worldFeatureDefinitionContainer = new WorldFeatureDefinitionContainer(configuredFeatureDefinition, placedFeatureDefinitions, biomeModifierDefinition);
        GenerationFeaturesDescriptionContainer.DEFINITIONS.put(configuredFeatureKey, worldFeatureDefinitionContainer);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return WorldFeatureGeneration.class;
    }
}
