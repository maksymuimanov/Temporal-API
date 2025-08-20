package com.temporal.api.core.event.tab;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;

public interface TabDirector {
    TabDirector direct(ResourceKey<CreativeModeTab> tab, ItemLike... items);

    TabDirector direct(boolean condition, ResourceKey<CreativeModeTab> tab, ItemLike... items);
}
