package com.temporal.api.core.engine.event.data.preparer.tag;

import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.Tags;

import java.util.*;

public final class ItemTagDynamicPreparer extends AbstractTagDynamicPreparer<Item> {
    public static final Set<Class<?>> TAG_CONTAINERS = new HashSet<>(List.of(ItemTags.class, Tags.Items.class));
    public static final Map<String, TagKey<Item>> ITEM_TAGS = new HashMap<>();

    @Override
    public Set<Class<?>> getTagContainers() {
        return TAG_CONTAINERS;
    }

    @Override
    public Map<String, TagKey<Item>> getTags() {
        return ITEM_TAGS;
    }
}
