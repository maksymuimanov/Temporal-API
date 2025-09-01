package com.temporal.api.core.engine.io.metadata.strategy.field.data.model;

import com.temporal.api.core.engine.io.metadata.annotation.data.model.GenerateWolfVariant;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.preparer.tag.BiomeTagDynamicPreparer;
import com.temporal.api.core.event.data.wolf.ApiWolfVariantProvider;
import com.temporal.api.core.event.data.wolf.WolfVariantDescriptionHolder;
import com.temporal.api.core.util.TagUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.WolfVariant;

import java.lang.reflect.Field;

public class GenerateWolfVariantStrategy implements FieldAnnotationStrategy<GenerateWolfVariant> {
    @Override
    public void execute(Field field, Object object, GenerateWolfVariant annotation) throws Exception {
        ResourceKey<WolfVariant> variantResourceKey = (ResourceKey<WolfVariant>) field.get(object);
        TagUtils.putTagContainer(BiomeTagDynamicPreparer.TAG_CONTAINERS, annotation.biomeTagContainer());
        ApiWolfVariantProvider.VARIANTS.add(new WolfVariantDescriptionHolder(variantResourceKey, annotation.biomeTag()));
    }

    @Override
    public Class<? extends GenerateWolfVariant> getAnnotationClass() {
        return GenerateWolfVariant.class;
    }
}
