package com.temporal.api.core.engine;

import com.temporal.api.core.engine.event.EventLayer;
import com.temporal.api.core.engine.event.handler.EventHandler;

import java.util.List;

public class EventBuilder {
    private final EngineBuilder engineBuilder;
    private final EventLayer eventLayer;
    private List<EventHandler> handlers;

    protected EventBuilder(EngineBuilder engineBuilder) {
        this.engineBuilder = engineBuilder;
        this.eventLayer = new EventLayer();
        engineBuilder.addLayer(eventLayer);
    }

    public EventBuilder handlers(List<EventHandler> handlers) {
        this.handlers = handlers;
        return this;
    }

    public EngineBuilder and() {
        EngineTask eventSetupTask = () -> {
            eventLayer.setAdditionalEventHandlers(handlers);
            engineBuilder.processLayer(eventLayer);
        };

        engineBuilder.addTask(eventSetupTask);
        return engineBuilder;
    }
}
