package com.temporal.api.core.event.data.biome.dto;

import com.temporal.api.core.event.data.biome.definition.BiomeModifierDefinition;
import com.temporal.api.core.event.data.biome.definition.ConfiguredFeatureDefinition;
import com.temporal.api.core.event.data.biome.definition.PlacedFeatureDefinition;

import java.util.List;

public record WorldFeatureDefinitionContainer(ConfiguredFeatureDefinition<?> configuredFeatureDefinition,
                                              List<PlacedFeatureDefinition> placedFeatureDefinition,
                                              BiomeModifierDefinition biomeModifierDefinition) {
}
