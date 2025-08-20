package com.temporal.api.core.event.data.biome;

import com.temporal.api.core.event.data.biome.dto.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.HashMap;
import java.util.Map;

public final class GenerationFeaturesDescriptionContainer {
    public static final Map<ResourceKey<ConfiguredFeature<?, ?>>, Ore> ORES = new HashMap<>();
    public static final Map<ResourceKey<ConfiguredFeature<?, ?>>, Tree> TREES = new HashMap<>();
    public static final Map<ResourceKey<ConfiguredFeature<?, ?>>, Flower> FLOWERS = new HashMap<>();
    public static final Map<ResourceKey<ConfiguredFeature<?, ?>>, Grass> GRASSES = new HashMap<>();
    public static final Map<ResourceKey<ConfiguredFeature<?, ?>>, WorldFeatureDefinitionContainer> DEFINITIONS = new HashMap<>();

    private GenerationFeaturesDescriptionContainer() {
    }
}
