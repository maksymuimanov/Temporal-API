package net.temporal.example.worldgen;

import com.temporal.api.core.engine.io.metadata.annotation.data.biome.FlowerGeneration;
import com.temporal.api.core.engine.io.metadata.annotation.data.biome.GrassGeneration;
import com.temporal.api.core.engine.io.metadata.annotation.data.biome.OreGeneration;
import com.temporal.api.core.engine.io.metadata.annotation.data.biome.TreeGeneration;
import com.temporal.api.core.engine.io.metadata.annotation.injection.Injected;
import com.temporal.api.core.engine.io.metadata.constant.OrePlacementShape;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

@Injected(false)
public final class ExampleConfiguredFeatures {
    @OreGeneration(
            blockId = "example:example_ore",
            replaceableBlocks = "minecraft:stone_ore_replaceables",
            size = 17,
            count = 20,
            shape = OrePlacementShape.TRIANGLE,
            from = 16,
            to = 112
    )
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXAMPLE_ORE_FEATURE = ResourceUtils.createKey(Registries.CONFIGURED_FEATURE, "example_ore_feature");

    @GrassGeneration(
            blockId = "example:example_grass",
            biomeTag = "minecraft:is_taiga"
    )
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXAMPLE_GRASS_FEATURE = ResourceUtils.createKey(Registries.CONFIGURED_FEATURE, "example_grass_feature");

    @FlowerGeneration(
            blockId = "example:example_flower",
            highStateFlowers = "minecraft:dandelion",
            lowStateFlowers = "minecraft:dandelion",
            biomeTag = "minecraft:is_forest"
    )
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXAMPLE_FLOWER_FEATURE = ResourceUtils.createKey(Registries.CONFIGURED_FEATURE, "example_flower_feature");

    @TreeGeneration(
            saplingBlockId = "example:example_sapling",
            logBlockId = "example:example_log",
            leavesBlockId = "example:example_leaves",
            trunk = @TreeGeneration.Trunk(baseHeight = 5, heightRandA = 3, heightRandB = 0),
            foliage = @TreeGeneration.Foliage(radius = 3, offset = 1, height = 2),
            featureSize = @TreeGeneration.FeatureSize(limit = 2, lowerSize = 1, upperSize = 2),
            baseValue = 1,
            chance = 1,
            addedAmount = 1
    )
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXAMPLE_TREE_FEATURE = ResourceUtils.createKey(Registries.CONFIGURED_FEATURE, "example_tree_feature");
}
