package com.temporal.api.core.engine.event.data.biome.configuration;

import com.temporal.api.core.engine.event.data.biome.GenerationDefinition;
import com.temporal.api.core.util.WorldGenerationUtils;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public interface ConfiguredFeatureDefinition<D, C extends FeatureConfiguration> extends GenerationDefinition<ConfiguredFeature<?, ?>, D> {
    @Override
    default void generate(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        this.getDataSource().forEach((configuredFeatureKey, data) -> {
            WorldGenerationUtils.registerFeature(context, configuredFeatureKey, getFeature(configuredFeatureKey, data), getFeatureConfiguration(configuredFeatureKey, data));
        });
    }

    Feature<C> getFeature(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, D data);

    C getFeatureConfiguration(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, D data);
}
