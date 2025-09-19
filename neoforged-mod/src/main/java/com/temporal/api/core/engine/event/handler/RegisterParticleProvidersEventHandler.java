package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.engine.metadata.annotation.injection.Handler;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

import java.util.Queue;
import java.util.function.Consumer;

@Handler(RegisterParticleProvidersEvent.class)
public class RegisterParticleProvidersEventHandler implements EventHandler {
    public static final Queue<Consumer<RegisterParticleProvidersEvent>> PROVIDER_REGISTRIES = new TemporalQueue<>();

    @Override
    public void handle() {
        this.subscribeModEvent(RegisterParticleProvidersEvent.class, event -> {
            PROVIDER_REGISTRIES.forEach(consumer -> consumer.accept(event));
        });
    }
}
