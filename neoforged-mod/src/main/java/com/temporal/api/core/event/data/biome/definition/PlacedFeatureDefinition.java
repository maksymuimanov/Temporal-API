package com.temporal.api.core.event.data.biome.definition;

import com.temporal.api.core.event.data.biome.placement.PlacedFeaturesContainer;
import com.temporal.api.core.util.biome.PlacedFeatureUtils;
import com.temporal.api.core.util.other.ResourceUtils;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public interface PlacedFeatureDefinition extends GenerationDefinition<PlacedFeature> {
    @Override
    default void generate(BootstrapContext<PlacedFeature> context, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey) {
        String registryName = ResourceUtils.getResourceId(configuredFeatureKey);
        String placedFeatureRegistryName = getName(registryName);
        ResourceKey<PlacedFeature> placedFeatureResourceKey = PlacedFeatureUtils.createKey(placedFeatureRegistryName);
        PlacedFeaturesContainer.PLACED_FEATURES.put(registryName, placedFeatureResourceKey);
        HolderGetter<ConfiguredFeature<?, ?>> featureHolderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        PlacedFeatureUtils.register(context, placedFeatureResourceKey, featureHolderGetter.getOrThrow(configuredFeatureKey), getPlacementModifiers());
    }

    default String getName(String registryName) {
        return registryName + "_placed";
    }

    List<PlacementModifier> getPlacementModifiers();
}
