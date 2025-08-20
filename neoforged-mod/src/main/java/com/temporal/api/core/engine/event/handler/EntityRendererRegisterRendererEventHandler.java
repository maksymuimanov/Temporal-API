package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.field.event.render.RegisterHangingSignRendererStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.field.event.render.RegisterSignRendererStrategy;
import com.temporal.api.core.util.IOUtils;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.function.Consumer;

public class EntityRendererRegisterRendererEventHandler implements EventHandler {
    public static final Queue<Consumer<EntityRenderersEvent.RegisterRenderers>> RENDERING_REGISTRIES = new TemporalQueue<>();
    private final Map<Class<? extends Annotation>, FieldAnnotationStrategy> strategies = IOUtils.createAnnotationStrategyMap(List.of(
            new RegisterSignRendererStrategy(),
            new RegisterHangingSignRendererStrategy()
    ));

    @Override
    public void handle() {
        IOLayer.SIMPLE_STRATEGY_CONSUMER.execute(IOLayer.STATIC_FIELD_EXECUTOR, strategies, IOLayer.NEO_MOD.getClasses());
        subscribeModEvent(EntityRenderersEvent.RegisterRenderers.class, event -> RENDERING_REGISTRIES.forEach(consumer -> consumer.accept(event)));
    }
}
