package com.temporal.api.core.event.data.biome.dto;

import com.temporal.api.core.engine.io.metadata.constant.TreeFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;

public record Tree(String id, Configuration configuration, Placement placement, BiomeModifier biomeModifier) {
    public record Configuration(String logBlock, String leavesBlock, String rootBlock,
                                Class<? extends TrunkPlacer> trunkPlacerClass, int baseHeight, int heightRandA, int heightRandB,
                                Class<? extends FoliagePlacer> foliagePlacerClass, int radius, int offset, int height,
                                TreeFeatureSize featureSize, int limit, int upperLimit,
                                int lowerSize, int middleSize, int upperSize, int minClippedHeight, boolean ignoreVines) {
    }

    public record Placement(String saplingBlock, int baseValue, float chance, int addedAmount) {
    }

    public record BiomeModifier(String biomeTag) {
    }
}
