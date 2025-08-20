package com.temporal.api.core.event.tab;

import com.temporal.api.core.exception.AddingToTabException;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public class SimpleTabAdder implements TabAdder {
    @Override
    public final void addAllToTab(BuildCreativeModeTabContentsEvent event, ResourceKey<CreativeModeTab> tab, ItemLike... items) {
        for (ItemLike item : items) {
            addToTab(event, tab, item);
        }
    }

    @Override
    public void addToTab(BuildCreativeModeTabContentsEvent event, ResourceKey<CreativeModeTab> tab, ItemLike item) {
        try {
            if (event.getTabKey() == tab) event.accept(item);
        } catch (Exception e) {
            throw new AddingToTabException("Adding to the %s gone wrong for %s".formatted(tab, item), e);
        }
    }
}
