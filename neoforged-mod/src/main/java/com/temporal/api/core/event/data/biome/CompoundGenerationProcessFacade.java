package com.temporal.api.core.event.data.biome;

import com.temporal.api.core.event.data.biome.configuration.*;
import com.temporal.api.core.event.data.biome.modifier.*;
import com.temporal.api.core.event.data.biome.placement.*;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;

import java.util.Map;

public final class CompoundGenerationProcessFacade {
    private CompoundGenerationProcessFacade() {
    }

    public static void executeConfiguredFeatures(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        executeProcess(context, new OreConfiguredFeaturesGenerationProcess(), GenerationFeaturesDescriptionContainer.ORES);
        executeProcess(context, new TreeConfiguredFeaturesGenerationProcess(), GenerationFeaturesDescriptionContainer.TREES);
        executeProcess(context, new FlowerConfiguredFeaturesGenerationProcess(), GenerationFeaturesDescriptionContainer.FLOWERS);
        executeProcess(context, new GrassConfiguredFeaturesGenerationProcess(), GenerationFeaturesDescriptionContainer.GRASSES);
        executeProcess(context, new DefinitionConfiguredFeaturesGenerationProcess(), GenerationFeaturesDescriptionContainer.DEFINITIONS);
    }

    public static void executePlacedFeatures(BootstrapContext<PlacedFeature> context) {
        executeProcess(context, new OrePlacedFeaturesGenerationProcess(), GenerationFeaturesDescriptionContainer.ORES);
        executeProcess(context, new TreePlacedFeaturesGenerationProcess(), GenerationFeaturesDescriptionContainer.TREES);
        executeProcess(context, new FlowerPlacedFeaturesGenerationProcess(), GenerationFeaturesDescriptionContainer.FLOWERS);
        executeProcess(context, new GrassPlacedFeaturesGenerationProcess(), GenerationFeaturesDescriptionContainer.GRASSES);
        executeProcess(context, new DefinitionPlacedFeaturesGenerationProcess(), GenerationFeaturesDescriptionContainer.DEFINITIONS);
    }

    public static void executeBiomeModifiers(BootstrapContext<BiomeModifier> context) {
        executeClearableProcess(context, new OreBiomeModifiersGenerationProcess(), GenerationFeaturesDescriptionContainer.ORES);
        executeClearableProcess(context, new TreeBiomeModifiersGenerationProcess(), GenerationFeaturesDescriptionContainer.TREES);
        executeClearableProcess(context, new FlowerBiomeModifiersGenerationProcess(), GenerationFeaturesDescriptionContainer.FLOWERS);
        executeClearableProcess(context, new GrassBiomeModifiersGenerationProcess(), GenerationFeaturesDescriptionContainer.GRASSES);
        executeClearableProcess(context, new DefinitionBiomeModifiersGenerationProcess(), GenerationFeaturesDescriptionContainer.DEFINITIONS);
    }

    private static <T, D> void executeClearableProcess(BootstrapContext<T> context, GenerationProcess<T, D> process, Map<ResourceKey<ConfiguredFeature<?, ?>>, D> data) {
        executeProcess(context, process, data);
        data.clear();
    }

    private static <T, D> void executeProcess(BootstrapContext<T> context, GenerationProcess<T, D> process, Map<ResourceKey<ConfiguredFeature<?, ?>>, D> data) {
        data.forEach((key, value) -> process.bootstrap(context, key, value));
    }
}
