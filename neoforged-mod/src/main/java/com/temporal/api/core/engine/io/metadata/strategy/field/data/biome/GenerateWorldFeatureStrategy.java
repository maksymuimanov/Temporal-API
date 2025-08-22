package com.temporal.api.core.engine.io.metadata.strategy.field.data.biome;

import com.temporal.api.core.engine.io.metadata.annotation.data.biome.GenerateWorldFeature;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.biome.GenerationDescriptionContainer;
import com.temporal.api.core.event.data.biome.configuration.ConfiguredFeatureDefinition;
import com.temporal.api.core.event.data.biome.modifier.BiomeModifierDefinition;
import com.temporal.api.core.event.data.biome.placement.PlacedFeatureDefinition;

import java.lang.reflect.Field;

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
}
