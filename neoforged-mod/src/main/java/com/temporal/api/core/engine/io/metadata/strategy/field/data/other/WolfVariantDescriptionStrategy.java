package com.temporal.api.core.engine.io.metadata.strategy.field.data.other;

import com.temporal.api.core.engine.io.metadata.annotation.data.other.WolfVariantDescription;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.preparer.tag.biome.BiomeTagDynamicPreparer;
import com.temporal.api.core.event.data.wolf.ApiWolfVariantProvider;
import com.temporal.api.core.event.data.wolf.WolfVariantDescriptionHolder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.WolfVariant;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class WolfVariantDescriptionStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        ResourceKey<WolfVariant> variantResourceKey = (ResourceKey<WolfVariant>) field.get(object);
        WolfVariantDescription wolfVariantDescription = field.getDeclaredAnnotation(WolfVariantDescription.class);
        Class<?> tagContainer = wolfVariantDescription.biomeTagContainer();
        if (!tagContainer.equals(Object.class)) BiomeTagDynamicPreparer.TAG_CONTAINERS.add(tagContainer);
        ApiWolfVariantProvider.VARIANTS.add(new WolfVariantDescriptionHolder(variantResourceKey, wolfVariantDescription.biomeTag()));
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return WolfVariantDescription.class;
    }
}
