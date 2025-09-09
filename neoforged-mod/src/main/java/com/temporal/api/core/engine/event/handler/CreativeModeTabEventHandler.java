package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.event.tab.SimpleTabDirector;
import com.temporal.api.core.engine.event.tab.TabDirector;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.pool.SimpleStrategyPool;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
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

    @Override
    public void handle() {
        this.subscribeModEvent(BuildCreativeModeTabContentsEvent.class, event -> {
            Map<Class<? extends Annotation>, FieldAnnotationStrategy<?>> strategies = SimpleStrategyPool.getInstance().getAll(StrategyPoolInitializer.DEFAULT_FIELD_EVENT_CREATIVE);
            if (CREATIVE_MODE_TABS_CONTENT.isEmpty()) MetadataLayer.ASYNC_STRATEGY_CONSUMER.execute(MetadataLayer.STATIC_FIELD_EXECUTOR, strategies, ModContext.ALL_CLASSES);
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
