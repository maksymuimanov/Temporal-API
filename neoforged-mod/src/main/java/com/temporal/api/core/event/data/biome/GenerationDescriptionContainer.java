package com.temporal.api.core.event.data.biome;

import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.event.data.biome.configuration.ConfiguredFeatureDefinition;
import com.temporal.api.core.event.data.biome.dto.Flower;
import com.temporal.api.core.event.data.biome.dto.Grass;
import com.temporal.api.core.event.data.biome.dto.Ore;
import com.temporal.api.core.event.data.biome.dto.Tree;
import com.temporal.api.core.event.data.biome.modifier.BiomeModifierDefinition;
import com.temporal.api.core.event.data.biome.placement.PlacedFeatureDefinition;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public final class GenerationDescriptionContainer {
    public static final Map<ResourceKey<ConfiguredFeature<?, ?>>, Ore> ORES = new HashMap<>();
    public static final Map<ResourceKey<ConfiguredFeature<?, ?>>, Tree> TREES = new HashMap<>();
    public static final Map<ResourceKey<ConfiguredFeature<?, ?>>, Flower> FLOWERS = new HashMap<>();
    public static final Map<ResourceKey<ConfiguredFeature<?, ?>>, Grass> GRASSES = new HashMap<>();
    public static final Queue<ConfiguredFeatureDefinition<?, ?>> CUSTOM_CONFIGURED_FEATURES = new TemporalQueue<>();
    public static final Queue<PlacedFeatureDefinition<?>> CUSTOM_PLACED_FEATURES = new TemporalQueue<>();
    public static final Queue<BiomeModifierDefinition<?>> CUSTOM_BIOME_MODIFIERS = new TemporalQueue<>();

    private GenerationDescriptionContainer() {
    }
}
