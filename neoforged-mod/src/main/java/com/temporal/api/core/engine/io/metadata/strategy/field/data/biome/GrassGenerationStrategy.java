package com.temporal.api.core.engine.io.metadata.strategy.field.data.biome;

import com.temporal.api.core.engine.io.metadata.annotation.data.biome.GrassGeneration;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.biome.GenerationDescriptionContainer;
import com.temporal.api.core.event.data.biome.dto.Grass;
import com.temporal.api.core.event.data.preparer.tag.biome.BiomeTagDynamicPreparer;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class GrassGenerationStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey = (ResourceKey<ConfiguredFeature<?, ?>>) field.get(object);
        GrassGeneration grassGeneration = field.getDeclaredAnnotation(GrassGeneration.class);
        Class<?> tagContainer = grassGeneration.biomeTagContainer();
        if (!tagContainer.equals(Object.class)) BiomeTagDynamicPreparer.TAG_CONTAINERS.add(tagContainer);
        var configuration = new Grass.Configuration(grassGeneration.blockId(), grassGeneration.tries());
        var placement = new Grass.Placement(grassGeneration.count());
        var biomeModifier = new Grass.BiomeModifier(grassGeneration.biomeTag());
        Grass grass = new Grass(ResourceUtils.getResourceId(configuredFeatureKey), configuration, placement, biomeModifier);
        GenerationDescriptionContainer.GRASSES.put(configuredFeatureKey, grass);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return GrassGeneration.class;
    }
}
