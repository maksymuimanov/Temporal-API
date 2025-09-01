package com.temporal.api.core.engine.io.metadata.strategy.field.data;

import com.temporal.api.core.engine.io.metadata.annotation.data.AddItemTag;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.preparer.tag.ItemTagDynamicPreparer;
import com.temporal.api.core.event.data.tag.ApiItemTagsProvider;
import com.temporal.api.core.util.MapUtils;
import com.temporal.api.core.util.ReflectionUtils;
import com.temporal.api.core.util.TagUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

public class AddItemTagStrategy implements FieldAnnotationStrategy<AddItemTag> {
    @Override
    public void execute(Field field, Object object, AddItemTag annotation) throws Exception {
        Holder<? extends Item> deferredItem = ReflectionUtils.getItemHolder(field, object);
        TagUtils.putTagContainer(ItemTagDynamicPreparer.TAG_CONTAINERS, annotation.tagContainer());
        for (String tag : annotation.value()) {
            MapUtils.putToListMap(ApiItemTagsProvider.TAG_GENERATION_DESCRIPTIONS, tag, deferredItem);
        }
    }

    @Override
    public Class<? extends AddItemTag> getAnnotationClass() {
        return AddItemTag.class;
    }
}
