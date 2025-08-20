package com.temporal.api.core.event.data.biome.modifier;

import com.temporal.api.core.event.data.biome.GenerationProcess;
import com.temporal.api.core.event.data.biome.dto.Grass;
import com.temporal.api.core.event.data.biome.placement.PlacedFeaturesContainer;
import com.temporal.api.core.event.data.preparer.tag.biome.BiomeTagDynamicPreparer;
import com.temporal.api.core.util.ResourceUtils;
import com.temporal.api.core.util.WorldGenerationUtils;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class GrassBiomeModifiersGenerationProcess implements GenerationProcess<BiomeModifier, Grass> {
    @Override
    public void bootstrap(BootstrapContext<BiomeModifier> context, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Grass description) {
        String configuredFeatureId = description.id();
        String registryName = ResourceUtils.mapId(configuredFeatureId, (path) -> "add_" + path);
        Grass.BiomeModifier biomeModifier = description.biomeModifier();
        ResourceKey<BiomeModifier> biomeModifierKey = ResourceUtils.createKey(NeoForgeRegistries.Keys.BIOME_MODIFIERS, registryName);
        BiomeModifiersContainer.BIOME_MODIFIERS.put(configuredFeatureId, biomeModifierKey);
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);
        TagKey<Biome> biomeTagKey = BiomeTagDynamicPreparer.BIOME_TAGS.get(biomeModifier.biomeTag());
        HolderSet.Named<Biome> foundBiomes = biomes.getOrThrow(biomeTagKey);
        ResourceKey<PlacedFeature> placedFeatureResourceKey = PlacedFeaturesContainer.PLACED_FEATURES.get(configuredFeatureId);
        HolderSet.Direct<PlacedFeature> placedFeature = HolderSet.direct(placedFeatures.getOrThrow(placedFeatureResourceKey));
        WorldGenerationUtils.registerFeature(context, biomeModifierKey, foundBiomes, placedFeature, GenerationStep.Decoration.VEGETAL_DECORATION);
    }
}
