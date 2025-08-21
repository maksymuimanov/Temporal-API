package com.temporal.api.core.event.data.biome.placement;

import com.temporal.api.core.event.data.biome.GenerationDescriptionContainer;
import com.temporal.api.core.event.data.biome.dto.Flower;
import com.temporal.api.core.util.CollectionUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;
import java.util.Map;

public class FlowerPlacedFeatureDefinition implements PlacedFeatureDefinition<Flower.Placement> {
    @Override
    public List<PlacementModifier> getPlacementModifiers(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Flower.Placement data) {
        return List.of(
                NoiseThresholdCountPlacement.of(data.noiseLevel(), data.belowNoise(), data.aboveNoise()),
                RarityFilter.onAverageOnceEvery(data.chance()),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome()
        );
    }

    @Override
    public Map<ResourceKey<ConfiguredFeature<?, ?>>, Flower.Placement> getDataSource() {
        return CollectionUtils.createMap(GenerationDescriptionContainer.FLOWERS, Flower::placement);
    }
}
