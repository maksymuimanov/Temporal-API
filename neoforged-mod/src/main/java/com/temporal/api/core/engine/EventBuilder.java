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
        this.engineBuilder.addLayer(this.eventLayer);
    }

    public EventBuilder handlers(List<EventHandler> handlers) {
        this.handlers = handlers;
        return this;
    }

    public EngineBuilder and() {
        EngineTask eventSetupTask = () -> {
            this.eventLayer.setAdditionalEventHandlers(handlers);
            this.engineBuilder.processLayer(eventLayer);
        };

        this.engineBuilder.addTask(eventSetupTask);
        return this.engineBuilder;
    }
}
