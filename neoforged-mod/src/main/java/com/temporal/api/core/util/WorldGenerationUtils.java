package com.temporal.api.core.util;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;

import java.util.List;

public final class WorldGenerationUtils {
    private WorldGenerationUtils() {
    }

    public static List<PlacementModifier> createCommonOrePlacement(int count, PlacementModifier heightRange) {
        return createOrePlacement(CountPlacement.of(count), heightRange);
    }

    public static List<PlacementModifier> createRareOrePlacement(int chance, PlacementModifier heightRange) {
        return createOrePlacement(RarityFilter.onAverageOnceEvery(chance), heightRange);
    }

    public static List<PlacementModifier> createOrePlacement(PlacementModifier countPlacement, PlacementModifier heightRange) {
        return List.of(countPlacement, InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> void registerFeature(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    public static void registerFeature(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    public static void registerFeature(BootstrapContext<BiomeModifier> context, ResourceKey<BiomeModifier> biomeModifierKey, HolderSet.Named<Biome> foundBiomes, HolderSet.Direct<PlacedFeature> placedFeature, GenerationStep.Decoration step) {
        context.register(biomeModifierKey, new BiomeModifiers.AddFeaturesBiomeModifier(foundBiomes, placedFeature, step));
    }
}
