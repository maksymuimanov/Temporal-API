package com.temporal.api.core.engine.io.metadata.strategy.field.data.tag;

import com.temporal.api.core.engine.io.metadata.annotation.data.AddItemTag;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.preparer.tag.item.ItemTagDynamicPreparer;
import com.temporal.api.core.event.data.tag.item.ApiItemTagsProvider;
import net.neoforged.neoforge.registries.DeferredItem;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class ItemTagComponentStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        AddItemTag annotation = field.getDeclaredAnnotation(AddItemTag.class);
        DeferredItem<?> deferredItem = (DeferredItem<?>) field.get(object);
        if (!annotation.tagContainer().equals(Object.class)) ItemTagDynamicPreparer.TAG_CONTAINERS.add(annotation.tagContainer());
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
    public Class<? extends Annotation> getAnnotationClass() {
        return AddItemTag.class;
    }
}
