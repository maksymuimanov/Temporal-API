package com.temporal.api.core.engine.io.metadata.annotation.data.biome;

import com.temporal.api.core.event.data.biome.definition.BiomeModifierDefinition;
import com.temporal.api.core.event.data.biome.definition.ConfiguredFeatureDefinition;
import com.temporal.api.core.event.data.biome.definition.PlacedFeatureDefinition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface WorldFeatureGeneration {
    Class<? extends ConfiguredFeatureDefinition<?>> configuredFeature();

    Class<? extends PlacedFeatureDefinition>[] placedFeatures();

    Class<? extends BiomeModifierDefinition> biomeModifier();
}
