package com.temporal.api.core.event.data.biome;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Map;

public interface GenerationDefinition<T, D> {
    void generate(BootstrapContext<T> context);

    Map<ResourceKey<ConfiguredFeature<?, ?>>, D> getDataSource();
}
