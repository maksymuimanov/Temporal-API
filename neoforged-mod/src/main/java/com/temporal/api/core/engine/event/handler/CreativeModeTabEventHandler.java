package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.engine.event.tab.SimpleTabDirector;
import com.temporal.api.core.engine.event.tab.TabDirector;
import com.temporal.api.core.engine.metadata.annotation.injection.Handler;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Handler(BuildCreativeModeTabContentsEvent.class)
public class CreativeModeTabEventHandler implements EventHandler {
    public static final Map<ResourceKey<CreativeModeTab>, List<Holder<? extends Item>>> CREATIVE_MODE_TABS_CONTENT = new HashMap<>();

    @Override
    public void handle() {
        this.subscribeModEvent(BuildCreativeModeTabContentsEvent.class, event -> {
            TabDirector tabDirector = SimpleTabDirector.create(event);
            CREATIVE_MODE_TABS_CONTENT.forEach((tab, items) -> {
                tabDirector.direct(tab, items.stream()
                        .map(Holder::value)
                        .map(item -> (ItemLike) item)
                        .toList());
            });
        });
    }
}
