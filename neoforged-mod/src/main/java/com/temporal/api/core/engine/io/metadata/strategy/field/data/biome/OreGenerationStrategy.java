package com.temporal.api.core.engine.io.metadata.strategy.field.data.biome;

import com.temporal.api.core.engine.io.metadata.annotation.data.biome.OreGeneration;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.biome.GenerationFeaturesDescriptionContainer;
import com.temporal.api.core.event.data.biome.dto.Ore;
import com.temporal.api.core.event.data.preparer.tag.biome.BiomeTagDynamicPreparer;
import com.temporal.api.core.util.other.ResourceUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class OreGenerationStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey = (ResourceKey<ConfiguredFeature<?, ?>>) field.get(object);
        OreGeneration oreGeneration = field.getDeclaredAnnotation(OreGeneration.class);
        Class<?> tagContainer = oreGeneration.biomeTagContainer();
        if (!tagContainer.equals(Object.class)) BiomeTagDynamicPreparer.TAG_CONTAINERS.add(tagContainer);
        var configuration = new Ore.Configuration(oreGeneration.blockId(), oreGeneration.replaceableBlocks(), oreGeneration.size());
        var placement = new Ore.Placement(oreGeneration.rarity(), oreGeneration.count(), oreGeneration.shape(), oreGeneration.from(), oreGeneration.to());
        var biomeModifier = new Ore.BiomeModifier(oreGeneration.biomeTag());
        Ore ore = new Ore(ResourceUtils.getResourceId(configuredFeatureKey), configuration, placement, biomeModifier);
        GenerationFeaturesDescriptionContainer.ORES.put(configuredFeatureKey, ore);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return OreGeneration.class;
    }
}
