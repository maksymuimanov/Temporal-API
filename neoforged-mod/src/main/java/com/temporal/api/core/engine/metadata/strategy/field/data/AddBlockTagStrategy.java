package com.temporal.api.core.engine.metadata.strategy.field.data;

import com.temporal.api.core.engine.event.data.preparer.tag.BlockTagDynamicPreparer;
import com.temporal.api.core.engine.event.data.tag.ApiBlockTagsProvider;
import com.temporal.api.core.engine.metadata.annotation.data.AddBlockTag;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.MapUtils;
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
            MapUtils.putToListMap(ApiBlockTagsProvider.TAG_GENERATION_DESCRIPTIONS, tag, deferredBlock);
        }
    }

    @Override
    public Class<? extends AddBlockTag> getAnnotationClass() {
        return AddBlockTag.class;
    }
}
