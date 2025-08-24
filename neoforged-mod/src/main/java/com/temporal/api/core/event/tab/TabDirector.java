package com.temporal.api.core.event.tab;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;

import java.util.List;

public interface TabDirector {
    default TabDirector direct(ResourceKey<CreativeModeTab> tab, Iterable<ItemLike> items) {
        return this.direct(true, tab, items);
    }

    default TabDirector direct(boolean condition, ResourceKey<CreativeModeTab> tab, ItemLike... items) {
        return this.direct(condition, tab, List.of(items));
    }

    default TabDirector direct(ResourceKey<CreativeModeTab> tab, ItemLike... items) {
        return this.direct(true, tab, items);
    }

    TabDirector direct(boolean condition, ResourceKey<CreativeModeTab> tab, Iterable<ItemLike> items);
}
