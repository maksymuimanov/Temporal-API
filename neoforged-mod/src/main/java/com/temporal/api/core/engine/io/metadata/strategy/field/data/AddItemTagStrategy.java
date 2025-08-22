package com.temporal.api.core.engine.io.metadata.strategy.field.data;

import com.temporal.api.core.engine.io.metadata.annotation.data.AddItemTag;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.preparer.tag.item.ItemTagDynamicPreparer;
import com.temporal.api.core.event.data.tag.item.ApiItemTagsProvider;
import com.temporal.api.core.util.TagUtils;
import net.neoforged.neoforge.registries.DeferredItem;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class AddItemTagStrategy implements FieldAnnotationStrategy<AddItemTag> {
    @Override
    public void execute(Field field, Object object, AddItemTag annotation) throws Exception {
        DeferredItem<?> deferredItem = (DeferredItem<?>) field.get(object);
        TagUtils.putTagContainer(ItemTagDynamicPreparer.TAG_CONTAINERS, annotation.tagContainer());
        for (String tag : annotation.value()) {
            boolean exists = ApiItemTagsProvider.TAG_GENERATION_DESCRIPTIONS.containsKey(tag);
            if (exists) {
                ApiItemTagsProvider.TAG_GENERATION_DESCRIPTIONS.get(tag).add(deferredItem);
            } else {
                ArrayList<DeferredItem<?>> items = new ArrayList<>();
                items.add(deferredItem);
                ApiItemTagsProvider.TAG_GENERATION_DESCRIPTIONS.put(tag, items);
            }
        }
    }

    @Override
    public Class<? extends AddItemTag> getAnnotationClass() {
        return AddItemTag.class;
    }
}
