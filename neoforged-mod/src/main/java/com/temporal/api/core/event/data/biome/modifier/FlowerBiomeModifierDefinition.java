package com.temporal.api.core.event.data.biome.modifier;

import com.temporal.api.core.event.data.biome.GenerationDescriptionContainer;
import com.temporal.api.core.event.data.biome.dto.Flower;
import com.temporal.api.core.event.data.preparer.tag.biome.BiomeTagDynamicPreparer;
import com.temporal.api.core.util.CollectionUtils;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Map;

public class FlowerBiomeModifierDefinition implements BiomeModifierDefinition<Flower.BiomeModifier> {
    @Override
    public HolderSet.Named<Biome> getBiomes(HolderGetter<Biome> biomes, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Flower.BiomeModifier data) {
        TagKey<Biome> biomeTagKey = BiomeTagDynamicPreparer.BIOME_TAGS.get(data.biomeTag());
        return biomes.getOrThrow(biomeTagKey);
    }

    @Override
    public GenerationStep.Decoration getGenerationDecoration(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Flower.BiomeModifier data) {
        return GenerationStep.Decoration.VEGETAL_DECORATION;
    }

    @Override
    public Map<ResourceKey<ConfiguredFeature<?, ?>>, Flower.BiomeModifier> getDataSource() {
        return CollectionUtils.createMap(GenerationDescriptionContainer.FLOWERS, Flower::biomeModifier);
    }
}
