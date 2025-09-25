package com.temporal.api.core.engine.event.data.biome.placement;

import com.temporal.api.core.engine.event.data.biome.GenerationDescriptionContainer;
import com.temporal.api.core.engine.event.data.biome.dto.Ore;
import com.temporal.api.core.util.MapUtils;
import com.temporal.api.core.util.WorldGenerationUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;
import java.util.Map;

public class OrePlacedFeatureDefinition implements PlacedFeatureDefinition<Ore.Placement> {
    @Override
    public List<PlacementModifier> getPlacementModifiers(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Ore.Placement data) {
        VerticalAnchor anchorFrom = VerticalAnchor.absolute(data.from());
        VerticalAnchor anchorTo = VerticalAnchor.absolute(data.to());
        HeightRangePlacement heightRangePlacement = switch (data.shape()) {
            case UNIFORM -> HeightRangePlacement.uniform(anchorFrom, anchorTo);
            case TRIANGLE -> HeightRangePlacement.triangle(anchorFrom, anchorTo);
        };
        return switch (data.rarity()) {
            case RARE -> WorldGenerationUtils.createRareOrePlacement(data.count(), heightRangePlacement);
            case COMMON -> WorldGenerationUtils.createCommonOrePlacement(data.count(), heightRangePlacement);
        };
    }

    @Override
    public Map<ResourceKey<ConfiguredFeature<?, ?>>, Ore.Placement> getDataSource() {
        return MapUtils.createMap(GenerationDescriptionContainer.ORES, Ore::placement);
    }
}
