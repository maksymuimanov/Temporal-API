package com.temporal.api.core.event.data.biome.placement;

import com.temporal.api.core.event.data.biome.GenerationDefinition;
import com.temporal.api.core.event.data.biome.PlacedFeaturesContainer;
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

public interface PlacedFeatureDefinition<D> extends GenerationDefinition<PlacedFeature, D> {
    @Override
    default void generate(BootstrapContext<PlacedFeature> context) {
        this.getDataSource().forEach((configuredFeatureKey, data) -> {
            String id = ResourceUtils.getResourceId(configuredFeatureKey);
            String placedFeatureName = this.getName(configuredFeatureKey, data);
            ResourceKey<PlacedFeature> placedFeature = ResourceUtils.createKey(Registries.PLACED_FEATURE, placedFeatureName);
            PlacedFeaturesContainer.PLACED_FEATURES.put(id, placedFeature);
            HolderGetter<ConfiguredFeature<?, ?>> featureHolderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
            WorldGenerationUtils.registerFeature(context, placedFeature, featureHolderGetter.getOrThrow(configuredFeatureKey), getPlacementModifiers(configuredFeatureKey, data));
        });
    }

    default String getName(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, D data) {
        return ResourceUtils.getResourceId(configuredFeatureKey) + "_placed";
    }

    List<PlacementModifier> getPlacementModifiers(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, D data);
}
