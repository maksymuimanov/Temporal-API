package com.temporal.api.core.event.data.biome.definition;

import com.temporal.api.core.util.biome.ConfiguredFeatureUtils;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public interface ConfiguredFeatureDefinition<C extends FeatureConfiguration> extends GenerationDefinition<ConfiguredFeature<?, ?>> {
    @Override
    default void generate(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey) {
        ConfiguredFeatureUtils.register(context, configuredFeatureKey, getFeature(), getFeatureConfiguration());
    }

    Feature<C> getFeature();

    C getFeatureConfiguration();
}
