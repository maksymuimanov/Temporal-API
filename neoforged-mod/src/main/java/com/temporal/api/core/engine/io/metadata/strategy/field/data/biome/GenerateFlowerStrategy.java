package com.temporal.api.core.engine.io.metadata.strategy.field.data.biome;

import com.temporal.api.core.engine.io.metadata.annotation.data.biome.GenerateFlower;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.biome.GenerationDescriptionContainer;
import com.temporal.api.core.event.data.biome.dto.Flower;
import com.temporal.api.core.event.data.preparer.tag.BiomeTagDynamicPreparer;
import com.temporal.api.core.util.ResourceUtils;
import com.temporal.api.core.util.TagUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.lang.reflect.Field;

public class GenerateFlowerStrategy implements FieldAnnotationStrategy<GenerateFlower> {
    @Override
    public void execute(Field field, Object object, GenerateFlower annotation) throws Exception {
        ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey = (ResourceKey<ConfiguredFeature<?, ?>>) field.get(object);
        var annotationConfiguration = annotation.configuration();
        var annotationPlacement = annotation.placement();
        var annotationBiomeModifier = annotation.biomeModifier();
        TagUtils.putTagContainer(BiomeTagDynamicPreparer.TAG_CONTAINERS, annotationBiomeModifier.biomeTagContainer());
        var configuration = new Flower.Configuration(annotationConfiguration.blockId(), annotationConfiguration.tries(), annotationConfiguration.xzSpread(), annotationConfiguration.ySpread(), annotationConfiguration.noiseSeed(), annotationConfiguration.noiseScale(), annotationConfiguration.noiseThreshold(), annotationConfiguration.noiseHighChance(), annotationConfiguration.firstOctave(), annotationConfiguration.amplitudes(), annotationConfiguration.lowStateFlowers(), annotationConfiguration.highStateFlowers());
        var placement = new Flower.Placement(annotationPlacement.chance(), annotationPlacement.noiseLevel(), annotationPlacement.belowNoise(), annotationPlacement.aboveNoise());
        var biomeModifier = new Flower.BiomeModifier(annotationBiomeModifier.biomeTag());
        Flower flower = new Flower(ResourceUtils.getResourceId(configuredFeatureKey), configuration, placement, biomeModifier);
        GenerationDescriptionContainer.FLOWERS.put(configuredFeatureKey, flower);
    }

    @Override
    public Class<? extends GenerateFlower> getAnnotationClass() {
        return GenerateFlower.class;
    }
}
