package com.temporal.api.core.event.data.biome.definition;

import com.temporal.api.core.event.data.biome.placement.PlacedFeaturesContainer;
import com.temporal.api.core.util.ResourceUtils;
import com.temporal.api.core.util.WorldGenerationUtils;
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
        String id = ResourceUtils.getResourceId(configuredFeatureKey);
        String placedFeatureRegistryName = this.getName(id);
        ResourceKey<PlacedFeature> placedFeature = ResourceUtils.createKey(Registries.PLACED_FEATURE, placedFeatureRegistryName);
        PlacedFeaturesContainer.PLACED_FEATURES.put(id, placedFeature);
        HolderGetter<ConfiguredFeature<?, ?>> featureHolderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        WorldGenerationUtils.registerFeature(context, placedFeature, featureHolderGetter.getOrThrow(configuredFeatureKey), getPlacementModifiers());
    }

    default String getName(String registryName) {
        return registryName + "_placed";
    }

    List<PlacementModifier> getPlacementModifiers();
}
