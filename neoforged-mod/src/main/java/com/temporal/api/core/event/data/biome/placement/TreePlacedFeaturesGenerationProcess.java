package com.temporal.api.core.event.data.biome.placement;

import com.temporal.api.core.event.data.biome.GenerationProcess;
import com.temporal.api.core.event.data.biome.dto.Tree;
import com.temporal.api.core.util.RegistryUtils;
import com.temporal.api.core.util.ResourceUtils;
import com.temporal.api.core.util.WorldGenerationUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class TreePlacedFeaturesGenerationProcess implements GenerationProcess<PlacedFeature, Tree> {
    @Override
    public void bootstrap(BootstrapContext<PlacedFeature> context, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Tree description) {
        var lookup = context.lookup(Registries.CONFIGURED_FEATURE);
        String registryName = description.id();
        var configuredFeatureReference = lookup.getOrThrow(configuredFeatureKey);
        String placedFeatureRegistryName = registryName + "_placed";
        ResourceKey<PlacedFeature> placedFeatureResourceKey = ResourceUtils.createKey(Registries.PLACED_FEATURE, placedFeatureRegistryName);
        PlacedFeaturesContainer.PLACED_FEATURES.put(registryName, placedFeatureResourceKey);
        Tree.Placement placement = description.placement();
        List<PlacementModifier> placementModifiers = VegetationPlacements.treePlacement(
                PlacementUtils.countExtra(placement.baseValue(), placement.chance(), placement.addedAmount()),
                RegistryUtils.getBlockById(placement.saplingBlock())
        );
        WorldGenerationUtils.registerFeature(context, placedFeatureResourceKey, configuredFeatureReference, placementModifiers);
    }
}
