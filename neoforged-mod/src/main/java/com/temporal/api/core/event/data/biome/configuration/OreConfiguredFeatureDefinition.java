package com.temporal.api.core.event.data.biome.configuration;

import com.temporal.api.core.event.data.biome.GenerationDescriptionContainer;
import com.temporal.api.core.event.data.biome.dto.Ore;
import com.temporal.api.core.util.CollectionUtils;
import com.temporal.api.core.util.RegistryUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;

import java.util.Arrays;
import java.util.Map;

public class OreConfiguredFeatureDefinition implements ConfiguredFeatureDefinition<Ore.Configuration, OreConfiguration> {
    @Override
    public Feature<OreConfiguration> getFeature(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Ore.Configuration data) {
        return Feature.ORE;
    }

    @Override
    public OreConfiguration getFeatureConfiguration(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Ore.Configuration data) {
        String[] replaceableBlocks = data.replaceableBlocks();
        var rules = BuiltInRegistries.BLOCK.stream()
                .filter(reg -> Arrays.asList(replaceableBlocks).contains(RegistryUtils.getIdFromRegistry(BuiltInRegistries.BLOCK, reg)))
                .map(BlockMatchTest::new)
                .map(rule -> OreConfiguration.target(rule, RegistryUtils.getBlock(data.blockId()).defaultBlockState()))
                .toList();
        return new OreConfiguration(rules, data.size());
    }

    @Override
    public Map<ResourceKey<ConfiguredFeature<?, ?>>, Ore.Configuration> getDataSource() {
        return CollectionUtils.createMap(GenerationDescriptionContainer.ORES, Ore::configuration);
    }
}
