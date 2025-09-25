package net.temporal.example.worldgen;

import com.temporal.api.core.engine.metadata.annotation.data.biome.GenerateFlower;
import com.temporal.api.core.engine.metadata.annotation.data.biome.GenerateGrass;
import com.temporal.api.core.engine.metadata.annotation.data.biome.GenerateOre;
import com.temporal.api.core.engine.metadata.annotation.data.biome.GenerateTree;
import com.temporal.api.core.engine.metadata.constant.OrePlacementShape;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public final class ExampleConfiguredFeatures {
    @GenerateOre(
            configuration = @GenerateOre.Configuration(
                    ore = "example:example_ore",
                    replaceableBlocks = "minecraft:sand",
                    replaceableBlocksTag = "minecraft:stone_ore_replaceables",
                    size = 17
            ),
            placement = @GenerateOre.Placement(
                    count = 20,
                    shape = OrePlacementShape.TRIANGLE,
                    from = 16,
                    to = 112
            )
    )
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXAMPLE_ORE_FEATURE = ResourceUtils.createKey(Registries.CONFIGURED_FEATURE, "example_ore_feature");

    @GenerateGrass(
            configuration = @GenerateGrass.Configuration(
                    grass = "example:example_grass"
            ),
            biomeModifier = @GenerateGrass.BiomeModifier(
                    biomeTag = "minecraft:is_taiga"
            )
    )
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXAMPLE_GRASS_FEATURE = ResourceUtils.createKey(Registries.CONFIGURED_FEATURE, "example_grass_feature");

    @GenerateFlower(
            configuration = @GenerateFlower.Configuration(
                    flower = "example:example_flower",
                    highStateFlowers = "minecraft:dandelion",
                    lowStateFlowers = "minecraft:dandelion"
            ),
            biomeModifier = @GenerateFlower.BiomeModifier(
                    biomeTag = "minecraft:is_forest"
            )
    )
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXAMPLE_FLOWER_FEATURE = ResourceUtils.createKey(Registries.CONFIGURED_FEATURE, "example_flower_feature");

    @GenerateTree(
            configuration = @GenerateTree.Configuration(
                    log = "example:example_log",
                    leaves = "example:example_leaves",
                    trunk = @GenerateTree.Trunk(baseHeight = 5, heightRandA = 3, heightRandB = 0),
                    foliage = @GenerateTree.Foliage(radius = 3, offset = 1, height = 2),
                    featureSize = @GenerateTree.FeatureSize(limit = 2, lowerSize = 1, upperSize = 2)
            ),
            placement = @GenerateTree.Placement(
                    sapling = "example:example_sapling",
                    baseValue = 1,
                    chance = 1,
                    addedAmount = 1
            )
    )
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXAMPLE_TREE_FEATURE = ResourceUtils.createKey(Registries.CONFIGURED_FEATURE, "example_tree_feature");
}
