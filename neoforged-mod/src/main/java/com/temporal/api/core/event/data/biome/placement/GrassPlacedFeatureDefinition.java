package com.temporal.api.core.event.data.biome.placement;

import com.temporal.api.core.event.data.biome.GenerationDescriptionContainer;
import com.temporal.api.core.event.data.biome.dto.Grass;
import com.temporal.api.core.util.CollectionUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;
import java.util.Map;

public class GrassPlacedFeatureDefinition implements PlacedFeatureDefinition<Grass.Placement> {
    @Override
    public List<PlacementModifier> getPlacementModifiers(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Grass.Placement data) {
        return VegetationPlacements.worldSurfaceSquaredWithCount(data.count());
    }

    @Override
    public Map<ResourceKey<ConfiguredFeature<?, ?>>, Grass.Placement> getDataSource() {
        return CollectionUtils.createMap(GenerationDescriptionContainer.GRASSES, Grass::placement);
    }
}
