package com.temporal.api.core.event.data.biome;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public interface GenerationProcess<T, D> {
    void bootstrap(BootstrapContext<T> context, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, D description);
}
