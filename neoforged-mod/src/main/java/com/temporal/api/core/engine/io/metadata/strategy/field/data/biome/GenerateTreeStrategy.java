package com.temporal.api.core.engine.io.metadata.strategy.field.data.biome;

import com.temporal.api.core.engine.io.metadata.annotation.data.biome.GenerateTree;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.biome.GenerationDescriptionContainer;
import com.temporal.api.core.event.data.biome.dto.Tree;
import com.temporal.api.core.event.data.preparer.tag.biome.BiomeTagDynamicPreparer;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class GenerateTreeStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey = (ResourceKey<ConfiguredFeature<?, ?>>) field.get(object);
        GenerateTree annotation = field.getDeclaredAnnotation(GenerateTree.class);
        var annotationConfiguration = annotation.configuration();
        var annotationPlacement = annotation.placement();
        var annotationBiomeModifier = annotation.biomeModifier();
        Class<?> tagContainer = annotationBiomeModifier.biomeTagContainer();
        if (!tagContainer.equals(Object.class)) BiomeTagDynamicPreparer.TAG_CONTAINERS.add(tagContainer);
        GenerateTree.Trunk trunk = annotationConfiguration.trunk();
        GenerateTree.Foliage foliage = annotationConfiguration.foliage();
        GenerateTree.FeatureSize featureSize = annotationConfiguration.featureSize();
        var configuration = new Tree.Configuration(annotationConfiguration.logBlockId(), annotationConfiguration.leavesBlockId(), annotationConfiguration.rootBlockId(),
                trunk.trunkPlacerClass(), trunk.baseHeight(), trunk.heightRandA(), trunk.heightRandB(),
                foliage.foliagePlacerClass(), foliage.radius(), foliage.offset(), foliage.height(),
                featureSize.type(), featureSize.limit(), featureSize.upperLimit(),
                featureSize.lowerSize(), featureSize.middleSize(), featureSize.upperSize(), featureSize.minClippedHeight(),
                annotationConfiguration.ignoreVines());
        var placement = new Tree.Placement(annotationPlacement.saplingBlockId(), annotationPlacement.baseValue(), annotationPlacement.chance(), annotationPlacement.addedAmount());
        var biomeModifier = new Tree.BiomeModifier(annotationBiomeModifier.biomeTag());
        Tree tree = new Tree(ResourceUtils.getResourceId(configuredFeatureKey), configuration, placement, biomeModifier);
        GenerationDescriptionContainer.TREES.put(configuredFeatureKey, tree);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return GenerateTree.class;
    }
}
