package com.temporal.api.core.engine.metadata.strategy.field.data.biome;

import com.temporal.api.core.engine.event.data.biome.GenerationDescriptionContainer;
import com.temporal.api.core.engine.event.data.biome.dto.Grass;
import com.temporal.api.core.engine.event.data.preparer.tag.BiomeTagDynamicPreparer;
import com.temporal.api.core.engine.metadata.annotation.data.biome.GenerateGrass;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.ResourceUtils;
import com.temporal.api.core.util.TagUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.lang.reflect.Field;

public class GenerateGrassStrategy implements FieldAnnotationStrategy<GenerateGrass> {
    @Override
    public void execute(Field field, Object object, GenerateGrass annotation) throws Exception {
        ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey = (ResourceKey<ConfiguredFeature<?, ?>>) field.get(object);
        var annotationConfiguration = annotation.configuration();
        var annotationPlacement = annotation.placement();
        var annotationBiomeModifier = annotation.biomeModifier();
        TagUtils.putTagContainer(BiomeTagDynamicPreparer.TAG_CONTAINERS, annotationBiomeModifier.biomeTagContainer());
        var configuration = new Grass.Configuration(annotationConfiguration.blockId(), annotationConfiguration.tries());
        var placement = new Grass.Placement(annotationPlacement.count());
        var biomeModifier = new Grass.BiomeModifier(annotationBiomeModifier.biomeTag());
        Grass grass = new Grass(ResourceUtils.getResourceId(configuredFeatureKey), configuration, placement, biomeModifier);
        GenerationDescriptionContainer.GRASSES.put(configuredFeatureKey, grass);
    }

    @Override
    public Class<? extends GenerateGrass> getAnnotationClass() {
        return GenerateGrass.class;
    }
}
