package com.temporal.api.core.event.data.biome.placement;

import com.temporal.api.core.event.data.biome.GenerationProcess;
import com.temporal.api.core.event.data.biome.dto.Ore;
import com.temporal.api.core.util.ResourceUtils;
import com.temporal.api.core.util.WorldGenerationUtils;
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
        ResourceKey<PlacedFeature> placedFeatureResourceKey = ResourceUtils.createKey(Registries.PLACED_FEATURE, placedFeatureRegistryName);
        PlacedFeaturesContainer.PLACED_FEATURES.put(registryName, placedFeatureResourceKey);
        Ore.Placement placement = description.placement();
        VerticalAnchor anchorFrom = VerticalAnchor.absolute(placement.from());
        VerticalAnchor anchorTo = VerticalAnchor.absolute(placement.to());
        HeightRangePlacement heightRangePlacement = switch (placement.shape()) {
            case UNIFORM -> HeightRangePlacement.uniform(anchorFrom, anchorTo);
            case TRIANGLE -> HeightRangePlacement.triangle(anchorFrom, anchorTo);
        };
        List<PlacementModifier> placementModifiers = switch (placement.rarity()) {
            case RARE -> WorldGenerationUtils.rareOrePlacement(placement.count(), heightRangePlacement);
            case COMMON -> WorldGenerationUtils.commonOrePlacement(placement.count(), heightRangePlacement);
        };
        WorldGenerationUtils.registerFeature(context, placedFeatureResourceKey, configuredFeatureReference, placementModifiers);
    }
}
