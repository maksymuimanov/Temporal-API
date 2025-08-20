package com.temporal.api.core.event.data.biome.definition;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public interface GenerationDefinition<T> {
    void generate(BootstrapContext<T> context, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey);
}
