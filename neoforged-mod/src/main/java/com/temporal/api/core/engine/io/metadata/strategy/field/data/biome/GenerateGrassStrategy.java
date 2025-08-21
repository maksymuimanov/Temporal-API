package com.temporal.api.core.engine.io.metadata.strategy.field.data.biome;

import com.temporal.api.core.engine.io.metadata.annotation.data.biome.GenerateGrass;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.biome.GenerationDescriptionContainer;
import com.temporal.api.core.event.data.biome.dto.Grass;
import com.temporal.api.core.event.data.preparer.tag.biome.BiomeTagDynamicPreparer;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class GenerateGrassStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey = (ResourceKey<ConfiguredFeature<?, ?>>) field.get(object);
        GenerateGrass annotation = field.getDeclaredAnnotation(GenerateGrass.class);
        var annotationConfiguration = annotation.configuration();
        var annotationPlacement = annotation.placement();
        var annotationBiomeModifier = annotation.biomeModifier();
        Class<?> tagContainer = annotationBiomeModifier.biomeTagContainer();
        if (!tagContainer.equals(Object.class)) BiomeTagDynamicPreparer.TAG_CONTAINERS.add(tagContainer);
        var configuration = new Grass.Configuration(annotationConfiguration.blockId(), annotationConfiguration.tries());
        var placement = new Grass.Placement(annotationPlacement.count());
        var biomeModifier = new Grass.BiomeModifier(annotationBiomeModifier.biomeTag());
        Grass grass = new Grass(ResourceUtils.getResourceId(configuredFeatureKey), configuration, placement, biomeModifier);
        GenerationDescriptionContainer.GRASSES.put(configuredFeatureKey, grass);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return GenerateGrass.class;
    }
}
