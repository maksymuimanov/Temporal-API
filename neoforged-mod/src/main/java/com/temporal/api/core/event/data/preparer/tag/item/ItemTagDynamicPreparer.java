package com.temporal.api.core.event.data.preparer.tag.item;

import com.temporal.api.core.event.data.preparer.DynamicPreparer;
import com.temporal.api.core.util.other.TagUtils;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.Tags;

import java.util.*;

public final class ItemTagDynamicPreparer implements DynamicPreparer {
    public static final Set<Class<?>> TAG_CONTAINERS = new HashSet<>(List.of(ItemTags.class, Tags.Items.class));
    public static final Map<String, TagKey<Item>> ITEM_TAGS = new HashMap<>();

    @Override
    public void prepare() {
        TAG_CONTAINERS.stream()
                .flatMap(TagUtils::<Item>getTagKeyStream)
                .forEach(tag -> TagUtils.putTagKey(tag, ITEM_TAGS));
    }
}
