package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.engine.metadata.annotation.injection.Handler;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.util.Queue;
import java.util.function.Consumer;

@Handler(EntityRenderersEvent.RegisterRenderers.class)
public class EntityRendererRegisterRendererEventHandler implements EventHandler {
    public static final Queue<Consumer<EntityRenderersEvent.RegisterRenderers>> RENDERING_REGISTRIES = new TemporalQueue<>();

    @Override
    public void handle() {
        this.subscribeModEvent(EntityRenderersEvent.RegisterRenderers.class, event -> {
            RENDERING_REGISTRIES.forEach(consumer -> consumer.accept(event));
        });
    }
}
