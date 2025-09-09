package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.pool.SimpleStrategyPool;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Queue;
import java.util.function.Consumer;

public class RegisterParticleProvidersEventHandler implements EventHandler {
    public static final Queue<Consumer<RegisterParticleProvidersEvent>> PROVIDER_REGISTRIES = new TemporalQueue<>();

    @Override
    public void handle() {
        this.subscribeModEvent(RegisterParticleProvidersEvent.class, event -> {
            Map<Class<? extends Annotation>, FieldAnnotationStrategy<?>> strategies = SimpleStrategyPool.getInstance().getAll(StrategyPoolInitializer.DEFAULT_FIELD_EVENT_PARTICLE);
            MetadataLayer.ASYNC_STRATEGY_CONSUMER.execute(MetadataLayer.STATIC_FIELD_EXECUTOR, strategies, ModContext.ALL_CLASSES);
            PROVIDER_REGISTRIES.forEach(consumer -> consumer.accept(event));
        });
    }
}
