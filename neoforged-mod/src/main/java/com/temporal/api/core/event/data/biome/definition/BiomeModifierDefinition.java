package com.temporal.api.core.event.data.biome.definition;

import com.temporal.api.core.event.data.biome.modifier.BiomeModifiersContainer;
import com.temporal.api.core.event.data.biome.placement.PlacedFeaturesContainer;
import com.temporal.api.core.util.ResourceUtils;
import com.temporal.api.core.util.WorldGenerationUtils;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public interface BiomeModifierDefinition extends GenerationDefinition<BiomeModifier> {
    @Override
    default void generate(BootstrapContext<BiomeModifier> context, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey) {
        String configuredFeatureId = ResourceUtils.getResourceId(configuredFeatureKey);
        String registryName = ResourceUtils.mapId(configuredFeatureId, (path) -> "add_" + path);
        ResourceKey<BiomeModifier> biomeModifierKey = ResourceUtils.createKey(NeoForgeRegistries.Keys.BIOME_MODIFIERS, registryName);
        BiomeModifiersContainer.BIOME_MODIFIERS.put(configuredFeatureId, biomeModifierKey);
        WorldGenerationUtils.registerFeature(context, biomeModifierKey,
                getBiomes(context.lookup(Registries.BIOME)),
                getPlacedFeature(context.lookup(Registries.PLACED_FEATURE), configuredFeatureKey),
                getGenerationDecoration());
    }

    HolderSet.Named<Biome> getBiomes(HolderGetter<Biome> biomes);

    default HolderSet.Direct<PlacedFeature> getPlacedFeature(HolderGetter<PlacedFeature> placedFeatures, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey) {
        ResourceKey<PlacedFeature> placedFeatureResourceKey = PlacedFeaturesContainer.PLACED_FEATURES.get(ResourceUtils.getResourceId(configuredFeatureKey));
        return HolderSet.direct(placedFeatures.getOrThrow(placedFeatureResourceKey));
    }

    GenerationStep.Decoration getGenerationDecoration();
}
