package com.temporal.api.core.engine.event;

import com.temporal.api.core.engine.EngineBuilder;
import com.temporal.api.core.engine.EngineTask;

public class EventLayerBuilder {
    private final EngineBuilder engineBuilder;
    private final EventLayer eventLayer;

    public EventLayerBuilder(EngineBuilder engineBuilder) {
        this.engineBuilder = engineBuilder;
        this.eventLayer = new EventLayer();
        this.engineBuilder.addLayer(this.eventLayer);
    }

    public EngineBuilder and() {
        EngineTask eventSetupTask = () -> {
            this.engineBuilder.processLayer(eventLayer);
        };
        this.engineBuilder.addTask(eventSetupTask);
        return this.engineBuilder;
    }
}
