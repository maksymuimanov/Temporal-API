package com.temporal.api.core.event.data.biome.placement;

import com.temporal.api.core.event.data.biome.GenerationProcess;
import com.temporal.api.core.event.data.biome.dto.Ore;
import com.temporal.api.core.util.biome.OrePlacements;
import com.temporal.api.core.util.biome.PlacedFeatureUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class OrePlacedFeaturesGenerationProcess implements GenerationProcess<PlacedFeature, Ore> {
    @Override
    public void bootstrap(BootstrapContext<PlacedFeature> context, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Ore description) {
        var lookup = context.lookup(Registries.CONFIGURED_FEATURE);
        String registryName = description.id();
        var configuredFeatureReference = lookup.getOrThrow(configuredFeatureKey);
        String placedFeatureRegistryName = registryName + "_placed";
        ResourceKey<PlacedFeature> placedFeatureResourceKey = PlacedFeatureUtils.createKey(placedFeatureRegistryName);
        PlacedFeaturesContainer.PLACED_FEATURES.put(registryName, placedFeatureResourceKey);
        Ore.Placement placement = description.placement();
        VerticalAnchor anchorFrom = VerticalAnchor.absolute(placement.from());
        VerticalAnchor anchorTo = VerticalAnchor.absolute(placement.to());
        HeightRangePlacement heightRangePlacement = switch (placement.shape()) {
            case UNIFORM -> HeightRangePlacement.uniform(anchorFrom, anchorTo);
            case TRIANGLE -> HeightRangePlacement.triangle(anchorFrom, anchorTo);
        };
        List<PlacementModifier> placementModifiers = switch (placement.rarity()) {
            case RARE -> OrePlacements.rareOrePlacement(placement.count(), heightRangePlacement);
            case COMMON -> OrePlacements.commonOrePlacement(placement.count(), heightRangePlacement);
        };
        PlacedFeatureUtils.register(context, placedFeatureResourceKey, configuredFeatureReference, placementModifiers);
    }
}
