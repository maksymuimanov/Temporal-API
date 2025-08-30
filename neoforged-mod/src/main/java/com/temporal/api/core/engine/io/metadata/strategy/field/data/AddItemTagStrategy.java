package com.temporal.api.core.engine.io.metadata.strategy.field.data;

import com.temporal.api.core.engine.io.metadata.annotation.data.AddItemTag;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.preparer.tag.item.ItemTagDynamicPreparer;
import com.temporal.api.core.event.data.tag.item.ApiItemTagsProvider;
import com.temporal.api.core.util.CollectionUtils;
import com.temporal.api.core.util.IOUtils;
import com.temporal.api.core.util.TagUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

public class AddItemTagStrategy implements FieldAnnotationStrategy<AddItemTag> {
    @Override
    public void execute(Field field, Object object, AddItemTag annotation) throws Exception {
        Holder<? extends Item> deferredItem = IOUtils.getItemHolder(field, object);
        TagUtils.putTagContainer(ItemTagDynamicPreparer.TAG_CONTAINERS, annotation.tagContainer());
        for (String tag : annotation.value()) {
            CollectionUtils.putToListMap(ApiItemTagsProvider.TAG_GENERATION_DESCRIPTIONS, tag, deferredItem);
        }
    }

    @Override
    public Class<? extends AddItemTag> getAnnotationClass() {
        return AddItemTag.class;
    }
}
