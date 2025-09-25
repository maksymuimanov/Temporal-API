package com.temporal.api.core.engine.event.data.biome;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.HashMap;
import java.util.Map;

public final class PlacedFeaturesContainer {
    public static final Map<String, ResourceKey<PlacedFeature>> PLACED_FEATURES = new HashMap<>();

    private PlacedFeaturesContainer() {
    }
}
