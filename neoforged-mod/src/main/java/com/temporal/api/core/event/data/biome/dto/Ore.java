package com.temporal.api.core.event.data.biome.dto;

import com.temporal.api.core.engine.io.metadata.constant.OrePlacementShape;
import com.temporal.api.core.engine.io.metadata.constant.OreRarity;

public record Ore(String id, Configuration configuration, Placement placement, BiomeModifier biomeModifier) {
    public record Configuration(String blockId, String[] replaceableBlocks, int size) {
    }

    public record Placement(OreRarity rarity, int count, OrePlacementShape shape, int from, int to) {
    }

    public record BiomeModifier(String biomeTag) {
    }
}
