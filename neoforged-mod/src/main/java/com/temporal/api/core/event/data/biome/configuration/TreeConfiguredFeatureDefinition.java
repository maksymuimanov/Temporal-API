package com.temporal.api.core.event.data.biome.configuration;

import com.temporal.api.ApiMod;
import com.temporal.api.core.event.data.biome.GenerationDescriptionContainer;
import com.temporal.api.core.event.data.biome.dto.Tree;
import com.temporal.api.core.util.CollectionUtils;
import com.temporal.api.core.util.RegistryUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.FeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.OptionalInt;

public class TreeConfiguredFeatureDefinition implements ConfiguredFeatureDefinition<Tree.Configuration, TreeConfiguration> {
    @Override
    public Feature<TreeConfiguration> getFeature(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Tree.Configuration data) {
        return Feature.TREE;
    }

    @Override
    public TreeConfiguration getFeatureConfiguration(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Tree.Configuration data) {
        try {
            TrunkPlacer trunkPlacer = getTrunkPlacer(data);
            FoliagePlacer foliagePlacer = getFoliagePlacer(data);
            FeatureSize featureSize = getFeatureSize(data);
            TreeConfiguration.TreeConfigurationBuilder builder = new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(RegistryUtils.getBlock(data.logBlock())),
                    trunkPlacer,
                    BlockStateProvider.simple(RegistryUtils.getBlock(data.leavesBlock())),
                    foliagePlacer,
                    featureSize
            ).dirt(BlockStateProvider.simple(RegistryUtils.getBlock(data.rootBlock())));
            builder = data.ignoreVines() ? builder.ignoreVines() : builder;
            return builder.build();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            ApiMod.LOGGER.error("Error while instantiating trunk placer or foliage placer", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<ResourceKey<ConfiguredFeature<?, ?>>, Tree.Configuration> getDataSource() {
        return CollectionUtils.createMap(GenerationDescriptionContainer.TREES, Tree::configuration);
    }

    private @NotNull TrunkPlacer getTrunkPlacer(Tree.Configuration configuration) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Constructor<? extends TrunkPlacer> trunkPlacerConstructor = configuration.trunkPlacerClass().getDeclaredConstructor(int.class, int.class, int.class);
        return trunkPlacerConstructor.newInstance(configuration.baseHeight(), configuration.heightRandA(), configuration.heightRandB());
    }

    private @NotNull FoliagePlacer getFoliagePlacer(Tree.Configuration configuration) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<? extends FoliagePlacer> foliagedPlacerClass = configuration.foliagePlacerClass();
        FoliagePlacer foliagePlacer;
        if (foliagedPlacerClass.equals(BlobFoliagePlacer.class)
                || foliagedPlacerClass.equals(FancyFoliagePlacer.class)
                || foliagedPlacerClass.equals(MegaJungleFoliagePlacer.class)) {
            Constructor<? extends FoliagePlacer> foliagePlacerConstructor = foliagedPlacerClass.getDeclaredConstructor(IntProvider.class, IntProvider.class, int.class);
            foliagePlacer = foliagePlacerConstructor.newInstance(ConstantInt.of(configuration.radius()), ConstantInt.of(configuration.offset()), configuration.height());
        } else if (foliagedPlacerClass.equals(PineFoliagePlacer.class)
                || foliagedPlacerClass.equals(MegaPineFoliagePlacer.class)
                || foliagedPlacerClass.equals(SpruceFoliagePlacer.class)) {
            Constructor<? extends FoliagePlacer> foliagePlacerConstructor = foliagedPlacerClass.getDeclaredConstructor(IntProvider.class, IntProvider.class, IntProvider.class);
            foliagePlacer = foliagePlacerConstructor.newInstance(ConstantInt.of(configuration.radius()), ConstantInt.of(configuration.offset()), ConstantInt.of(configuration.height()));
        } else {
            Constructor<? extends FoliagePlacer> foliagePlacerConstructor = foliagedPlacerClass.getDeclaredConstructor(IntProvider.class, IntProvider.class);
            foliagePlacer = foliagePlacerConstructor.newInstance(ConstantInt.of(configuration.radius()), ConstantInt.of(configuration.offset()));
        }

        return foliagePlacer;
    }

    private @NotNull FeatureSize getFeatureSize(Tree.Configuration configuration) {
        return switch (configuration.featureSize()) {
            case TWO_LAYERED ->
                    new TwoLayersFeatureSize(configuration.limit(), configuration.lowerSize(), configuration.upperSize(), OptionalInt.of(configuration.minClippedHeight()));
            case THREE_LAYERED ->
                    new ThreeLayersFeatureSize(configuration.limit(), configuration.upperLimit(), configuration.lowerSize(), configuration.middleSize(), configuration.upperSize(), OptionalInt.of(configuration.minClippedHeight()));
        };
    }
}