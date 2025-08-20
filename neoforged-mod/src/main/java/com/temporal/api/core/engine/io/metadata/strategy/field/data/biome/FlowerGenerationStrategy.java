package com.temporal.api.core.engine.io.metadata.strategy.field.data.biome;

import com.temporal.api.core.engine.io.metadata.annotation.data.biome.FlowerGeneration;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.biome.GenerationFeaturesDescriptionContainer;
import com.temporal.api.core.event.data.biome.dto.Flower;
import com.temporal.api.core.event.data.preparer.tag.biome.BiomeTagDynamicPreparer;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class FlowerGenerationStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey = (ResourceKey<ConfiguredFeature<?, ?>>) field.get(object);
        FlowerGeneration flowerGeneration = field.getDeclaredAnnotation(FlowerGeneration.class);
        Class<?> tagContainer = flowerGeneration.biomeTagContainer();
        if (!tagContainer.equals(Object.class)) BiomeTagDynamicPreparer.TAG_CONTAINERS.add(tagContainer);
        var configuration = new Flower.Configuration(flowerGeneration.blockId(), flowerGeneration.tries(), flowerGeneration.xzSpread(), flowerGeneration.ySpread(), flowerGeneration.noiseSeed(), flowerGeneration.noiseScale(), flowerGeneration.noiseThreshold(), flowerGeneration.noiseHighChance(), flowerGeneration.firstOctave(), flowerGeneration.amplitudes(), flowerGeneration.lowStateFlowers(), flowerGeneration.highStateFlowers());
        var placement = new Flower.Placement(flowerGeneration.chance(), flowerGeneration.noiseLevel(), flowerGeneration.belowNoise(), flowerGeneration.aboveNoise());
        var biomeModifier = new Flower.BiomeModifier(flowerGeneration.biomeTag());
        Flower flower = new Flower(ResourceUtils.getResourceId(configuredFeatureKey), configuration, placement, biomeModifier);
        GenerationFeaturesDescriptionContainer.FLOWERS.put(configuredFeatureKey, flower);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return FlowerGeneration.class;
    }
}
