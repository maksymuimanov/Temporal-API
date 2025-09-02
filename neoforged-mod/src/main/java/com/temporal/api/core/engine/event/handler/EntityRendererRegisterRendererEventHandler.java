package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.field.event.RegisterBlockEntityRendererStrategy;
import com.temporal.api.core.engine.metadata.strategy.field.event.RegisterEntityRendererStrategy;
import com.temporal.api.core.util.ReflectionUtils;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.function.Consumer;

public class EntityRendererRegisterRendererEventHandler implements EventHandler {
    public static final Queue<Consumer<EntityRenderersEvent.RegisterRenderers>> RENDERING_REGISTRIES = new TemporalQueue<>();
    private final Map<Class<? extends Annotation>, FieldAnnotationStrategy<?>> strategies = ReflectionUtils.createAnnotationStrategyMap(List.of(
            new RegisterEntityRendererStrategy(),
            new RegisterBlockEntityRendererStrategy()
    ));

    @Override
    public void handle() {
        subscribeModEvent(EntityRenderersEvent.RegisterRenderers.class, event -> {
            MetadataLayer.ASYNC_STRATEGY_CONSUMER.execute(MetadataLayer.STATIC_FIELD_EXECUTOR, strategies, ModContext.NEO_MOD.getClasses());
            RENDERING_REGISTRIES.forEach(consumer -> consumer.accept(event));
        });
    }
}
