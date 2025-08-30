package com.temporal.api.core.engine.io.metadata.strategy.field.data;

import com.temporal.api.core.engine.io.metadata.annotation.data.AddBlockTag;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.preparer.tag.block.BlockTagDynamicPreparer;
import com.temporal.api.core.event.data.tag.block.ApiBlockTagsProvider;
import com.temporal.api.core.util.CollectionUtils;
import com.temporal.api.core.util.TagUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

public class AddBlockTagStrategy implements FieldAnnotationStrategy<AddBlockTag> {
    @Override
    public void execute(Field field, Object object, AddBlockTag annotation) throws Exception {
        Holder<? extends Block> deferredBlock = (Holder<? extends Block>) field.get(object);
        TagUtils.putTagContainer(BlockTagDynamicPreparer.TAG_CONTAINERS, annotation.tagContainer());
        for (String tag : annotation.value()) {
            CollectionUtils.putToListMap(ApiBlockTagsProvider.TAG_GENERATION_DESCRIPTIONS, tag, deferredBlock);
        }
    }

    @Override
    public Class<? extends AddBlockTag> getAnnotationClass() {
        return AddBlockTag.class;
    }
}
