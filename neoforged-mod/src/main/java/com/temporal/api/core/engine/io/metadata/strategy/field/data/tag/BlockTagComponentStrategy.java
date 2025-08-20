package com.temporal.api.core.engine.io.metadata.strategy.field.data.tag;

import com.temporal.api.core.engine.io.metadata.annotation.data.tag.BlockTagComponent;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.preparer.tag.block.BlockTagDynamicPreparer;
import com.temporal.api.core.event.data.tag.block.ApiBlockTagsProvider;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class BlockTagComponentStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        BlockTagComponent annotation = field.getDeclaredAnnotation(BlockTagComponent.class);
        DeferredBlock<?> deferredBlock = (DeferredBlock<?>) field.get(object);
        if (!annotation.tagContainer().equals(Object.class)) BlockTagDynamicPreparer.TAG_CONTAINERS.add(annotation.tagContainer());
        for (String tag : annotation.value()) {
            boolean exists = ApiBlockTagsProvider.TAG_GENERATION_DESCRIPTIONS.containsKey(tag);
            if (exists) {
                ApiBlockTagsProvider.TAG_GENERATION_DESCRIPTIONS.get(tag).add(deferredBlock);
            } else {
                ArrayList<DeferredBlock<?>> blocks = new ArrayList<>();
                blocks.add(deferredBlock);
                ApiBlockTagsProvider.TAG_GENERATION_DESCRIPTIONS.put(tag, blocks);
            }
        }
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return BlockTagComponent.class;
    }
}
