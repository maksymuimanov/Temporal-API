package com.temporal.api.core.event.data.biome;

import com.temporal.api.core.event.data.biome.configuration.FlowerConfiguredFeatureDefinition;
import com.temporal.api.core.event.data.biome.configuration.GrassConfiguredFeatureDefinition;
import com.temporal.api.core.event.data.biome.configuration.OreConfiguredFeatureDefinition;
import com.temporal.api.core.event.data.biome.configuration.TreeConfiguredFeatureDefinition;
import com.temporal.api.core.event.data.biome.modifier.FlowerBiomeModifierDefinition;
import com.temporal.api.core.event.data.biome.modifier.GrassBiomeModifierDefinition;
import com.temporal.api.core.event.data.biome.modifier.OreBiomeModifierDefinition;
import com.temporal.api.core.event.data.biome.modifier.TreeBiomeModifierDefinition;
import com.temporal.api.core.event.data.biome.placement.FlowerPlacedFeatureDefinition;
import com.temporal.api.core.event.data.biome.placement.GrassPlacedFeatureDefinition;
import com.temporal.api.core.event.data.biome.placement.OrePlacedFeatureDefinition;
import com.temporal.api.core.event.data.biome.placement.TreePlacedFeatureDefinition;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;

import java.util.List;

public final class CompoundGenerationDefinitionFacade {
    private CompoundGenerationDefinitionFacade() {
    }

    public static void executeConfiguredFeatures(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        executeAll(context, List.of(
                new FlowerConfiguredFeatureDefinition(),
                new GrassConfiguredFeatureDefinition(),
                new OreConfiguredFeatureDefinition(),
                new TreeConfiguredFeatureDefinition()
        ));
        GenerationDescriptionContainer.CUSTOM_CONFIGURED_FEATURES.forEach(definition -> definition.generate(context));
    }

    public static void executePlacedFeatures(BootstrapContext<PlacedFeature> context) {
        executeAll(context, List.of(
                new FlowerPlacedFeatureDefinition(),
                new GrassPlacedFeatureDefinition(),
                new OrePlacedFeatureDefinition(),
                new TreePlacedFeatureDefinition()
        ));
        GenerationDescriptionContainer.CUSTOM_PLACED_FEATURES.forEach(definition -> definition.generate(context));
    }

    public static void executeBiomeModifiers(BootstrapContext<BiomeModifier> context) {
        executeAll(context, List.of(
                new FlowerBiomeModifierDefinition(),
                new GrassBiomeModifierDefinition(),
                new OreBiomeModifierDefinition(),
                new TreeBiomeModifierDefinition()
        ));
        GenerationDescriptionContainer.CUSTOM_BIOME_MODIFIERS.forEach(definition -> definition.generate(context));
    }

    @SafeVarargs
    private static <T> void executeAll(BootstrapContext<T> context, Iterable<GenerationDefinition<T, ?>>... definitions) {
        for (Iterable<GenerationDefinition<T, ?>> definitionIterable : definitions) {
            definitionIterable.forEach(definition -> definition.generate(context));
        }
    }
}
