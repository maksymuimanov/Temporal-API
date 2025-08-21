package com.temporal.api.core.engine.io.metadata.strategy.field.data.biome;

import com.temporal.api.core.engine.io.metadata.annotation.data.biome.GenerateOre;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.biome.GenerationDescriptionContainer;
import com.temporal.api.core.event.data.biome.dto.Ore;
import com.temporal.api.core.event.data.preparer.tag.biome.BiomeTagDynamicPreparer;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class GenerateOreStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey = (ResourceKey<ConfiguredFeature<?, ?>>) field.get(object);
        GenerateOre annotation = field.getDeclaredAnnotation(GenerateOre.class);
        var annotationConfiguration = annotation.configuration();
        var annotationPlacement = annotation.placement();
        var annotationBiomeModifier = annotation.biomeModifier();
        Class<?> tagContainer = annotationBiomeModifier.biomeTagContainer();
        if (!tagContainer.equals(Object.class)) BiomeTagDynamicPreparer.TAG_CONTAINERS.add(tagContainer);
        var configuration = new Ore.Configuration(annotationConfiguration.blockId(), annotationConfiguration.replaceableBlocks(), annotationConfiguration.size());
        var placement = new Ore.Placement(annotationPlacement.rarity(), annotationPlacement.count(), annotationPlacement.shape(), annotationPlacement.from(), annotationPlacement.to());
        var biomeModifier = new Ore.BiomeModifier(annotationBiomeModifier.biomeTag());
        Ore ore = new Ore(ResourceUtils.getResourceId(configuredFeatureKey), configuration, placement, biomeModifier);
        GenerationDescriptionContainer.ORES.put(configuredFeatureKey, ore);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return GenerateOre.class;
    }
}
