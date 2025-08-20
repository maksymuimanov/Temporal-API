package com.temporal.api.core.event.data.biome.configuration;

import com.temporal.api.core.event.data.biome.GenerationProcess;
import com.temporal.api.core.event.data.biome.dto.Grass;
import com.temporal.api.core.util.biome.ConfiguredFeatureUtils;
import com.temporal.api.core.util.other.RegistryUtils;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class GrassConfiguredFeaturesGenerationProcess implements GenerationProcess<ConfiguredFeature<?, ?>, Grass> {
    @Override
    public void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Grass description) {
        Grass.Configuration configuration = description.configuration();
        ConfiguredFeatureUtils.register(context, configuredFeatureKey, Feature.RANDOM_PATCH,
                FeatureUtils.simpleRandomPatchConfiguration(
                        configuration.tries(), PlacementUtils.onlyWhenEmpty(
                                Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                                        BlockStateProvider.simple(RegistryUtils.getBlockById(configuration.blockId()))
                                )
                        )
                )
        );
    }
}
