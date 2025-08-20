package com.temporal.api.core.event.data.biome.configuration;

import com.temporal.api.core.event.data.biome.GenerationProcess;
import com.temporal.api.core.event.data.biome.dto.Ore;
import com.temporal.api.core.util.biome.ConfiguredFeatureUtils;
import com.temporal.api.core.util.other.RegistryUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;

import java.util.Arrays;

public class OreConfiguredFeaturesGenerationProcess implements GenerationProcess<ConfiguredFeature<?, ?>, Ore> {
    @Override
    public void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Ore description) {
        Ore.Configuration configuration = description.configuration();
        String[] replaceableBlocks = configuration.replaceableBlocks();
        var rules = BuiltInRegistries.BLOCK.stream()
                .filter(reg -> Arrays.asList(replaceableBlocks).contains(RegistryUtils.getIdFromRegistry(BuiltInRegistries.BLOCK, reg)))
                .map(BlockMatchTest::new)
                .map(rule -> OreConfiguration.target(rule, RegistryUtils.getBlockById(configuration.blockId()).defaultBlockState()))
                .toList();
        ConfiguredFeatureUtils.register(context, configuredFeatureKey, Feature.ORE, new OreConfiguration(rules, configuration.size()));
    }
}
