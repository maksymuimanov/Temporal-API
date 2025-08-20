package com.temporal.api.core.engine.io.metadata.strategy.type.data.tag;

import com.temporal.api.core.engine.io.metadata.annotation.data.tag.TagContainer;
import com.temporal.api.core.engine.io.metadata.strategy.type.ClassAnnotationStrategy;
import com.temporal.api.core.event.data.preparer.tag.biome.BiomeTagDynamicPreparer;
import com.temporal.api.core.event.data.preparer.tag.block.BlockTagDynamicPreparer;
import com.temporal.api.core.event.data.preparer.tag.enchantment.EnchantmentTagDynamicPreparer;
import com.temporal.api.core.event.data.preparer.tag.item.ItemTagDynamicPreparer;

import java.lang.annotation.Annotation;

public class TagContainerStrategy implements ClassAnnotationStrategy {
    @Override
    public void execute(Class<?> clazz, Object object) throws Exception {
        TagContainer annotation = clazz.getDeclaredAnnotation(TagContainer.class);
        switch (annotation.value()) {
            case ITEM -> ItemTagDynamicPreparer.TAG_CONTAINERS.add(clazz);
            case BLOCK -> BlockTagDynamicPreparer.TAG_CONTAINERS.add(clazz);
            case BIOME -> BiomeTagDynamicPreparer.TAG_CONTAINERS.add(clazz);
            case ENCHANTMENT -> EnchantmentTagDynamicPreparer.TAG_CONTAINERS.add(clazz);
        }
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return TagContainer.class;
    }
}
