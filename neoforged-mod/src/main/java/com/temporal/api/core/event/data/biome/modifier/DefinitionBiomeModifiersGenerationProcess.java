package com.temporal.api.core.event.data.biome.modifier;

import com.temporal.api.core.event.data.biome.GenerationProcess;
import com.temporal.api.core.event.data.biome.definition.BiomeModifierDefinition;
import com.temporal.api.core.event.data.biome.dto.WorldFeatureDefinitionContainer;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;

public class DefinitionBiomeModifiersGenerationProcess implements GenerationProcess<BiomeModifier, WorldFeatureDefinitionContainer> {
    @Override
    public void bootstrap(BootstrapContext<BiomeModifier> context, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, WorldFeatureDefinitionContainer description) {
        BiomeModifierDefinition definition = description.biomeModifierDefinition();
        definition.generate(context, configuredFeatureKey);
    }
}
