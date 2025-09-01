package com.temporal.api.core.engine.io.metadata.strategy.field.data.biome;

import com.temporal.api.core.engine.io.metadata.annotation.data.biome.GenerateOre;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.biome.GenerationDescriptionContainer;
import com.temporal.api.core.event.data.biome.dto.Ore;
import com.temporal.api.core.event.data.preparer.tag.BiomeTagDynamicPreparer;
import com.temporal.api.core.event.data.preparer.tag.BlockTagDynamicPreparer;
import com.temporal.api.core.util.ResourceUtils;
import com.temporal.api.core.util.TagUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.lang.reflect.Field;

public class GenerateOreStrategy implements FieldAnnotationStrategy<GenerateOre> {
    @Override
    public void execute(Field field, Object object, GenerateOre annotation) throws Exception {
        ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey = (ResourceKey<ConfiguredFeature<?, ?>>) field.get(object);
        var annotationConfiguration = annotation.configuration();
        var annotationPlacement = annotation.placement();
        var annotationBiomeModifier = annotation.biomeModifier();
        TagUtils.putTagContainer(BlockTagDynamicPreparer.TAG_CONTAINERS, annotationConfiguration.blockTagContainer());
        TagUtils.putTagContainer(BiomeTagDynamicPreparer.TAG_CONTAINERS, annotationBiomeModifier.biomeTagContainer());
        var configuration = new Ore.Configuration(annotationConfiguration.blockId(), annotationConfiguration.replaceableBlocksIds(), annotationConfiguration.replaceableBlocksTag(), annotationConfiguration.size(), annotationConfiguration.discardChanceOnAirExposure());
        var placement = new Ore.Placement(annotationPlacement.rarity(), annotationPlacement.count(), annotationPlacement.shape(), annotationPlacement.from(), annotationPlacement.to());
        var biomeModifier = new Ore.BiomeModifier(annotationBiomeModifier.biomeTag());
        Ore ore = new Ore(ResourceUtils.getResourceId(configuredFeatureKey), configuration, placement, biomeModifier);
        GenerationDescriptionContainer.ORES.put(configuredFeatureKey, ore);
    }

    @Override
    public Class<? extends GenerateOre> getAnnotationClass() {
        return GenerateOre.class;
    }
}
