package com.temporal.api.core.event.tab;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public interface TabAdder {
    void addAllToTab(BuildCreativeModeTabContentsEvent event, ResourceKey<CreativeModeTab> tab, ItemLike... items);

    void addToTab(BuildCreativeModeTabContentsEvent event, ResourceKey<CreativeModeTab> tab, ItemLike item);
}
