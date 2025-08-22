package com.temporal.api.core.engine.io.metadata.strategy.field.data;

import com.temporal.api.core.engine.io.metadata.annotation.data.AddBlockTag;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.preparer.tag.block.BlockTagDynamicPreparer;
import com.temporal.api.core.event.data.tag.block.ApiBlockTagsProvider;
import com.temporal.api.core.util.TagUtils;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class AddBlockTagStrategy implements FieldAnnotationStrategy<AddBlockTag> {
    @Override
    public void execute(Field field, Object object, AddBlockTag annotation) throws Exception {
        DeferredBlock<?> deferredBlock = (DeferredBlock<?>) field.get(object);
        TagUtils.putTagContainer(BlockTagDynamicPreparer.TAG_CONTAINERS, annotation.tagContainer());
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
    public Class<? extends AddBlockTag> getAnnotationClass() {
        return AddBlockTag.class;
    }
}
