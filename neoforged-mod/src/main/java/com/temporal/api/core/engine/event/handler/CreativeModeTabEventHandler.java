package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.field.event.AddCreativeModeTabStrategy;
import com.temporal.api.core.event.tab.SimpleTabDirector;
import com.temporal.api.core.event.tab.TabDirector;
import com.temporal.api.core.util.IOUtils;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreativeModeTabEventHandler implements EventHandler {
    public static final Map<ResourceKey<CreativeModeTab>, List<Holder<? extends Item>>> CREATIVE_MODE_TABS_CONTENT = new HashMap<>();
    private static final Map<Class<? extends Annotation>, FieldAnnotationStrategy<?>> STRATEGIES = IOUtils.createAnnotationStrategyMap(List.of(
            new AddCreativeModeTabStrategy()
    ));

    @Override
    public void handle() {
        subscribeModEvent(BuildCreativeModeTabContentsEvent.class, event -> {
            IOLayer.ASYNC_STRATEGY_CONSUMER.execute(IOLayer.STATIC_FIELD_EXECUTOR, STRATEGIES, IOLayer.NEO_MOD.getClasses());
            TabDirector tabDirector = SimpleTabDirector.create(event);
            CREATIVE_MODE_TABS_CONTENT.forEach((tab, items) -> {
                tabDirector.direct(tab, items.stream()
                        .map(Holder::value)
                        .map(item -> (ItemLike) item)
                        .toList());
            });
            CREATIVE_MODE_TABS_CONTENT.clear();
        });
    }
}
