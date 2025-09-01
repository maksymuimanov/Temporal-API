package com.temporal.api.core.engine.io.metadata.strategy.field.data.biome;

import com.temporal.api.core.engine.io.metadata.annotation.data.biome.GenerateTree;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.biome.GenerationDescriptionContainer;
import com.temporal.api.core.event.data.biome.dto.Tree;
import com.temporal.api.core.event.data.preparer.tag.BiomeTagDynamicPreparer;
import com.temporal.api.core.util.ResourceUtils;
import com.temporal.api.core.util.TagUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.lang.reflect.Field;

public class GenerateTreeStrategy implements FieldAnnotationStrategy<GenerateTree> {
    @Override
    public void execute(Field field, Object object, GenerateTree annotation) throws Exception {
        ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey = (ResourceKey<ConfiguredFeature<?, ?>>) field.get(object);
        var annotationConfiguration = annotation.configuration();
        var annotationPlacement = annotation.placement();
        var annotationBiomeModifier = annotation.biomeModifier();
        TagUtils.putTagContainer(BiomeTagDynamicPreparer.TAG_CONTAINERS, annotationBiomeModifier.biomeTagContainer());
        var configuration = this.getTreeConfiguration(annotationConfiguration);
        var placement = new Tree.Placement(annotationPlacement.saplingBlockId(), annotationPlacement.baseValue(), annotationPlacement.chance(), annotationPlacement.addedAmount());
        var biomeModifier = new Tree.BiomeModifier(annotationBiomeModifier.biomeTag());
        Tree tree = new Tree(ResourceUtils.getResourceId(configuredFeatureKey), configuration, placement, biomeModifier);
        GenerationDescriptionContainer.TREES.put(configuredFeatureKey, tree);
    }

    private Tree.Configuration getTreeConfiguration(GenerateTree.Configuration annotationConfiguration) {
        GenerateTree.Trunk trunk = annotationConfiguration.trunk();
        GenerateTree.Foliage foliage = annotationConfiguration.foliage();
        GenerateTree.FeatureSize featureSize = annotationConfiguration.featureSize();
        var configuration = new Tree.Configuration(annotationConfiguration.logBlockId(), annotationConfiguration.leavesBlockId(), annotationConfiguration.rootBlockId(),
                trunk.trunkPlacerClass(), trunk.baseHeight(), trunk.heightRandA(), trunk.heightRandB(),
                foliage.foliagePlacerClass(), foliage.radius(), foliage.offset(), foliage.height(),
                featureSize.type(), featureSize.limit(), featureSize.upperLimit(),
                featureSize.lowerSize(), featureSize.middleSize(), featureSize.upperSize(), featureSize.minClippedHeight(),
                annotationConfiguration.ignoreVines());
        return configuration;
    }

    @Override
    public Class<? extends GenerateTree> getAnnotationClass() {
        return GenerateTree.class;
    }
}
