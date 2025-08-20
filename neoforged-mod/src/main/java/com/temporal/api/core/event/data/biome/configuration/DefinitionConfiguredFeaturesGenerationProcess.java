package com.temporal.api.core.event.data.biome.configuration;

import com.temporal.api.core.event.data.biome.GenerationProcess;
import com.temporal.api.core.event.data.biome.definition.ConfiguredFeatureDefinition;
import com.temporal.api.core.event.data.biome.dto.WorldFeatureDefinitionContainer;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class DefinitionConfiguredFeaturesGenerationProcess implements GenerationProcess<ConfiguredFeature<?, ?>, WorldFeatureDefinitionContainer> {
    @Override
    public void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, WorldFeatureDefinitionContainer description) {
        ConfiguredFeatureDefinition<?> definition = description.configuredFeatureDefinition();
        definition.generate(context, configuredFeatureKey);
    }
}
