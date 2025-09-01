package com.temporal.api.core.engine.io.metadata.strategy.type.data;

import com.temporal.api.core.engine.io.metadata.annotation.data.RegisterTagContainer;
import com.temporal.api.core.engine.io.metadata.strategy.type.ClassAnnotationStrategy;
import com.temporal.api.core.event.data.preparer.tag.BiomeTagDynamicPreparer;
import com.temporal.api.core.event.data.preparer.tag.BlockTagDynamicPreparer;
import com.temporal.api.core.event.data.preparer.tag.EnchantmentTagDynamicPreparer;
import com.temporal.api.core.event.data.preparer.tag.ItemTagDynamicPreparer;

public class RegisterTagContainerStrategy implements ClassAnnotationStrategy<RegisterTagContainer> {
    @Override
    public void execute(Class<?> clazz, Object object, RegisterTagContainer annotation) throws Exception {
        switch (annotation.value()) {
            case ITEM -> ItemTagDynamicPreparer.TAG_CONTAINERS.add(clazz);
            case BLOCK -> BlockTagDynamicPreparer.TAG_CONTAINERS.add(clazz);
            case BIOME -> BiomeTagDynamicPreparer.TAG_CONTAINERS.add(clazz);
            case ENCHANTMENT -> EnchantmentTagDynamicPreparer.TAG_CONTAINERS.add(clazz);
        }
    }

    @Override
    public Class<? extends RegisterTagContainer> getAnnotationClass() {
        return RegisterTagContainer.class;
    }
}
