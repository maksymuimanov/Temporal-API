package com.temporal.api.core.event.data.biome.configuration;

import com.temporal.api.core.event.data.biome.GenerationDescriptionContainer;
import com.temporal.api.core.event.data.biome.dto.Flower;
import com.temporal.api.core.util.MapUtils;
import com.temporal.api.core.util.RegistryUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseThresholdProvider;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.Arrays;
import java.util.Map;

public class FlowerConfiguredFeatureDefinition implements ConfiguredFeatureDefinition<Flower.Configuration, RandomPatchConfiguration> {
    @Override
    public Feature<RandomPatchConfiguration> getFeature(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Flower.Configuration data) {
        return Feature.FLOWER;
    }

    @Override
    public RandomPatchConfiguration getFeatureConfiguration(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Flower.Configuration data) {
        return new RandomPatchConfiguration(data.tries(), data.xzSpread(), data.ySpread(),
                PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(
                                new NoiseThresholdProvider(data.noiseSeed(),
                                        new NormalNoise.NoiseParameters(data.firstOctave(), Arrays.stream(data.amplitudes()).boxed().toList()),
                                        data.noiseScale(),
                                        data.noiseThreshold(),
                                        data.noiseHighChance(),
                                        RegistryUtils.getBlock(data.blockId()).defaultBlockState(),
                                        Arrays.stream(data.lowStateFlowers())
                                                .map(RegistryUtils::getBlock)
                                                .map(Block::defaultBlockState)
                                                .toList(),
                                        Arrays.stream(data.highStateFlowers())
                                                .map(RegistryUtils::getBlock)
                                                .map(Block::defaultBlockState)
                                                .toList()))));
    }

    @Override
    public Map<ResourceKey<ConfiguredFeature<?, ?>>, Flower.Configuration> getDataSource() {
        return MapUtils.createMap(GenerationDescriptionContainer.FLOWERS, Flower::configuration);
    }
}
