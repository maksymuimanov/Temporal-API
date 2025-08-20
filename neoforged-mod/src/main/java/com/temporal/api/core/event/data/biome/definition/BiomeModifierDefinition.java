package com.temporal.api.core.event.data.biome.definition;

import com.temporal.api.core.event.data.biome.modifier.BiomeModifiersContainer;
import com.temporal.api.core.event.data.biome.placement.PlacedFeaturesContainer;
import com.temporal.api.core.util.biome.BiomeModifiersUtils;
import com.temporal.api.core.util.other.ResourceUtils;
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

public interface BiomeModifierDefinition extends GenerationDefinition<BiomeModifier> {
    @Override
    default void generate(BootstrapContext<BiomeModifier> context, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey) {
        String registryName = ResourceUtils.getResourceId(configuredFeatureKey);
        ResourceKey<BiomeModifier> biomeModifierKey = BiomeModifiersUtils.registerKey("add_" + registryName);
        BiomeModifiersContainer.BIOME_MODIFIERS.put(registryName, biomeModifierKey);
        BiomeModifiersUtils.register(context, biomeModifierKey,
                getBiomes(context.lookup(Registries.BIOME)),
                getPlacedFeature(context.lookup(Registries.PLACED_FEATURE), configuredFeatureKey),
                getGenerationDecoration());
    }

    HolderSet.Named<Biome> getBiomes(HolderGetter<Biome> biomes);

    default HolderSet.Direct<PlacedFeature> getPlacedFeature(HolderGetter<PlacedFeature> placedFeatures, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey) {
        return HolderSet.direct(placedFeatures.getOrThrow(PlacedFeaturesContainer.PLACED_FEATURES.get(ResourceUtils.getResourceId(configuredFeatureKey))));
    }

    GenerationStep.Decoration getGenerationDecoration();
}
