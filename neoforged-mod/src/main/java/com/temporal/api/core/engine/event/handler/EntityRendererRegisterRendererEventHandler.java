package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.event.RegisterBlockEntityRenderer;
import com.temporal.api.core.engine.metadata.annotation.event.RegisterEntityRenderer;
import com.temporal.api.core.engine.metadata.pool.SimpleStrategyPool;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Queue;
import java.util.function.Consumer;

public class EntityRendererRegisterRendererEventHandler implements EventHandler {
    public static final Queue<Consumer<EntityRenderersEvent.RegisterRenderers>> RENDERING_REGISTRIES = new TemporalQueue<>();

    @Override
    public void handle() {
        this.subscribeModEvent(EntityRenderersEvent.RegisterRenderers.class, event -> {
            Map<Class<? extends Annotation>, FieldAnnotationStrategy<?>> strategies = SimpleStrategyPool.getInstance().getStrategies(RegisterEntityRenderer.class, RegisterBlockEntityRenderer.class);
            MetadataLayer.ASYNC_STRATEGY_CONSUMER.execute(MetadataLayer.STATIC_FIELD_EXECUTOR, strategies, ModContext.NEO_MOD.getClasses());
            RENDERING_REGISTRIES.forEach(consumer -> consumer.accept(event));
        });
    }
}
