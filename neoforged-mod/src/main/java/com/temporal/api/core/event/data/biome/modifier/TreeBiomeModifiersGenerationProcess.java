package com.temporal.api.core.event.data.biome.modifier;

import com.temporal.api.core.event.data.biome.GenerationProcess;
import com.temporal.api.core.event.data.biome.dto.Tree;
import com.temporal.api.core.event.data.biome.placement.PlacedFeaturesContainer;
import com.temporal.api.core.event.data.preparer.tag.biome.BiomeTagDynamicPreparer;
import com.temporal.api.core.util.biome.BiomeModifiersUtils;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;

public class TreeBiomeModifiersGenerationProcess implements GenerationProcess<BiomeModifier, Tree> {
    @Override
    public void bootstrap(BootstrapContext<BiomeModifier> context, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Tree description) {
        String registryName = description.id();
        Tree.BiomeModifier biomeModifier = description.biomeModifier();
        ResourceKey<BiomeModifier> biomeModifierKey = BiomeModifiersUtils.registerKey("add_" + registryName);
        BiomeModifiersContainer.BIOME_MODIFIERS.put(registryName, biomeModifierKey);
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);
        TagKey<Biome> biomeTagKey = BiomeTagDynamicPreparer.BIOME_TAGS.get(biomeModifier.biomeTag());
        HolderSet.Named<Biome> foundBiomes = biomes.getOrThrow(biomeTagKey);
        context.register(biomeModifierKey, new BiomeModifiers.AddFeaturesBiomeModifier(
                foundBiomes,
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeaturesContainer.PLACED_FEATURES.get(registryName))),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));
    }
}
