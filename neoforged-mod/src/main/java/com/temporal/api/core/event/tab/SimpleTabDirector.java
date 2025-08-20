package com.temporal.api.core.event.tab;

import com.temporal.api.ApiMod;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public class SimpleTabDirector implements TabDirector {
    private final TabAdder tabAdder;
    private final BuildCreativeModeTabContentsEvent event;

    public SimpleTabDirector(TabAdder tabAdder, BuildCreativeModeTabContentsEvent event) {
        this.tabAdder = tabAdder;
        this.event = event;
    }

    public static SimpleTabDirector create(BuildCreativeModeTabContentsEvent event) {
        return new SimpleTabDirector(new SimpleTabAdder(), event);
    }

    public final TabDirector direct(ResourceKey<CreativeModeTab> tab, ItemLike... items) {
        return this.direct(true, tab, items);
    }

    @Override
    @SafeVarargs
    public final TabDirector direct(boolean condition, ResourceKey<CreativeModeTab> tab, ItemLike... items) {
        if (condition) {
            try {
                this.tabAdder.addAllToTab(this.event, tab, items);
            } catch (Exception e) {
                ApiMod.LOGGER.error("Tab adding gone wrong!", e);
            }
        } else {
            ApiMod.LOGGER.info("Tab adding hasn't been processed, because condition: false");
        }

        return this;
    }
}
