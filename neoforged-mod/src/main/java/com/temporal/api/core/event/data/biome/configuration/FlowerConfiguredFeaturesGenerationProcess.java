package com.temporal.api.core.event.data.biome.configuration;

import com.temporal.api.core.event.data.biome.GenerationProcess;
import com.temporal.api.core.event.data.biome.dto.Flower;
import com.temporal.api.core.util.biome.ConfiguredFeatureUtils;
import com.temporal.api.core.util.other.RegistryUtils;
import net.minecraft.data.worldgen.BootstrapContext;
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

public class FlowerConfiguredFeaturesGenerationProcess implements GenerationProcess<ConfiguredFeature<?, ?>, Flower> {
    @Override
    public void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Flower description) {
        Flower.Configuration configuration = description.configuration();
        ConfiguredFeatureUtils.register(context, configuredFeatureKey, Feature.FLOWER,
                new RandomPatchConfiguration(configuration.tries(), configuration.xzSpread(), configuration.ySpread(),
                        PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(
                                        new NoiseThresholdProvider(configuration.noiseSeed(),
                                                new NormalNoise.NoiseParameters(configuration.firstOctave(), Arrays.stream(configuration.amplitudes()).boxed().toList()),
                                                configuration.noiseScale(),
                                                configuration.noiseThreshold(),
                                                configuration.noiseHighChance(),
                                                RegistryUtils.getBlockById(configuration.blockId()).defaultBlockState(),
                                                Arrays.stream(configuration.lowStateFlowers())
                                                        .map(RegistryUtils::getBlockById)
                                                        .map(Block::defaultBlockState)
                                                        .toList(),
                                                Arrays.stream(configuration.highStateFlowers())
                                                        .map(RegistryUtils::getBlockById)
                                                        .map(Block::defaultBlockState)
                                                        .toList())))));
    }
}
