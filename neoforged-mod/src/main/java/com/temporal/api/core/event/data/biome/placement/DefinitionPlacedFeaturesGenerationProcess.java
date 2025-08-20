package com.temporal.api.core.event.data.biome.placement;

import com.temporal.api.core.event.data.biome.GenerationProcess;
import com.temporal.api.core.event.data.biome.definition.PlacedFeatureDefinition;
import com.temporal.api.core.event.data.biome.dto.WorldFeatureDefinitionContainer;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class DefinitionPlacedFeaturesGenerationProcess implements GenerationProcess<PlacedFeature, WorldFeatureDefinitionContainer> {
    @Override
    public void bootstrap(BootstrapContext<PlacedFeature> context, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, WorldFeatureDefinitionContainer description) {
        List<PlacedFeatureDefinition> placedFeatureDefinitions = description.placedFeatureDefinition();
        for (PlacedFeatureDefinition definition : placedFeatureDefinitions) {
            definition.generate(context, configuredFeatureKey);
        }
  }
}
