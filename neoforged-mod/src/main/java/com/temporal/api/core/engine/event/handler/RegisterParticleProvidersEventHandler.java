package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.injection.Handler;
import com.temporal.api.core.engine.metadata.pool.SimpleStrategyPool;
import com.temporal.api.core.engine.metadata.pool.StrategyPool;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

import java.util.Queue;
import java.util.function.Consumer;

@Handler(RegisterParticleProvidersEvent.class)
public class RegisterParticleProvidersEventHandler implements EventHandler {
    public static final Queue<Consumer<RegisterParticleProvidersEvent>> PROVIDER_REGISTRIES = new TemporalQueue<>();

    @Override
    public void handle() {
        this.subscribeModEvent(RegisterParticleProvidersEvent.class, event -> {
            StrategyPool strategyPool = SimpleStrategyPool.getInstance();
            MetadataLayer.ASYNC_STRATEGY_CONSUMER.execute(strategyPool.getAll(StrategyPoolInitializer.DEFAULT_FIELD_EVENT_PARTICLE), ModContext.ALL_CLASSES);
            PROVIDER_REGISTRIES.forEach(consumer -> consumer.accept(event));
        });
    }
}
