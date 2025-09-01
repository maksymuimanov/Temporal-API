package com.temporal.api.core.event.data.preparer.tag;

import com.temporal.api.core.event.data.preparer.DynamicPreparer;
import com.temporal.api.core.util.TagUtils;
import net.minecraft.tags.TagKey;

import java.util.Map;
import java.util.Set;

public abstract class AbstractTagDynamicPreparer<T> implements DynamicPreparer {
    @Override
    public void prepare() {
        this.getTagContainers()
                .stream()
                .flatMap(TagUtils::<T>getTagKeyStream)
                .forEach(tag -> TagUtils.putTagKey(tag, this.getTags()));
    }

    public abstract Set<Class<?>> getTagContainers();

    public abstract Map<String, TagKey<T>> getTags();
}
