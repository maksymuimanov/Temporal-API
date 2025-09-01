package com.temporal.api.core.event.data.biome.configuration;

import com.temporal.api.core.event.data.biome.GenerationDescriptionContainer;
import com.temporal.api.core.event.data.biome.dto.Ore;
import com.temporal.api.core.event.data.preparer.tag.BlockTagDynamicPreparer;
import com.temporal.api.core.util.MapUtils;
import com.temporal.api.core.util.RegistryUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OreConfiguredFeatureDefinition implements ConfiguredFeatureDefinition<Ore.Configuration, OreConfiguration> {
    @Override
    public Feature<OreConfiguration> getFeature(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Ore.Configuration data) {
        return Feature.ORE;
    }

    @Override
    public OreConfiguration getFeatureConfiguration(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Ore.Configuration data) {
        List<OreConfiguration.TargetBlockState> rules = new ArrayList<>();
        List<String> replaceableBlocksIds = List.of(data.replaceableBlocksIds());
        if (!replaceableBlocksIds.isEmpty()) {
            for (String id : replaceableBlocksIds) {
                Block block = RegistryUtils.getBlock(id);
                BlockMatchTest blockMatchTest = new BlockMatchTest(block);
                OreConfiguration.TargetBlockState target = OreConfiguration.target(blockMatchTest, this.getBlockState(data));
                rules.add(target);
            }
        }
        String replaceableBlocksTag = data.replaceableBlocksTag();
        if (!replaceableBlocksTag.isBlank()) {
            TagKey<Block> blockTagKey = BlockTagDynamicPreparer.BLOCK_TAGS.get(replaceableBlocksTag);
            TagMatchTest tagMatchTest = new TagMatchTest(blockTagKey);
            OreConfiguration.TargetBlockState target = OreConfiguration.target(tagMatchTest, this.getBlockState(data));
            rules.add(target);
        }
        if (rules.isEmpty()) throw new IllegalStateException("Ore rules are empty!");
        return new OreConfiguration(rules, data.size(), data.discardChanceOnAirExposure());
    }

    @NotNull
    private BlockState getBlockState(Ore.Configuration data) {
        return RegistryUtils.getBlock(data.blockId()).defaultBlockState();
    }

    @Override
    public Map<ResourceKey<ConfiguredFeature<?, ?>>, Ore.Configuration> getDataSource() {
        return MapUtils.createMap(GenerationDescriptionContainer.ORES, Ore::configuration);
    }
}
