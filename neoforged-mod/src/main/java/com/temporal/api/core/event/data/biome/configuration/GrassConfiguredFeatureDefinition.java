package com.temporal.api.core.event.data.biome.configuration;

import com.temporal.api.core.event.data.biome.GenerationDescriptionContainer;
import com.temporal.api.core.event.data.biome.dto.Grass;
import com.temporal.api.core.util.CollectionUtils;
import com.temporal.api.core.util.RegistryUtils;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.Map;

public class GrassConfiguredFeatureDefinition implements ConfiguredFeatureDefinition<Grass.Configuration, RandomPatchConfiguration> {
    @Override
    public Feature<RandomPatchConfiguration> getFeature(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Grass.Configuration data) {
        return Feature.RANDOM_PATCH;
    }

    @Override
    public RandomPatchConfiguration getFeatureConfiguration(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Grass.Configuration data) {
        return FeatureUtils.simpleRandomPatchConfiguration(
                data.tries(), PlacementUtils.onlyWhenEmpty(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                                BlockStateProvider.simple(RegistryUtils.getBlockById(data.blockId()))
                        )
                )
        );
    }

    @Override
    public Map<ResourceKey<ConfiguredFeature<?, ?>>, Grass.Configuration> getDataSource() {
        return CollectionUtils.createMap(GenerationDescriptionContainer.GRASSES, Grass::configuration);
    }
}
