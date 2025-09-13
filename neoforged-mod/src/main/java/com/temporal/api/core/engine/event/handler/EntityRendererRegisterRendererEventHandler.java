package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.injection.Handler;
import com.temporal.api.core.engine.metadata.pool.SimpleStrategyPool;
import com.temporal.api.core.engine.metadata.pool.StrategyPool;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.util.Queue;
import java.util.function.Consumer;

@Handler(EntityRenderersEvent.RegisterRenderers.class)
public class EntityRendererRegisterRendererEventHandler implements EventHandler {
    public static final Queue<Consumer<EntityRenderersEvent.RegisterRenderers>> RENDERING_REGISTRIES = new TemporalQueue<>();

    @Override
    public void handle() {
        this.subscribeModEvent(EntityRenderersEvent.RegisterRenderers.class, event -> {
            StrategyPool strategyPool = SimpleStrategyPool.getInstance();
            MetadataLayer.ASYNC_STRATEGY_CONSUMER.execute(strategyPool.getAll(StrategyPoolInitializer.DEFAULT_FIELD_EVENT_RENDERER), ModContext.ALL_CLASSES);
            RENDERING_REGISTRIES.forEach(consumer -> consumer.accept(event));
        });
    }
}
