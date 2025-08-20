package com.temporal.api.core.engine.event;

import com.temporal.api.core.engine.EngineLayer;
import com.temporal.api.core.engine.event.handler.EventHandler;

import java.util.List;

public class EventLayer implements EngineLayer {
    private List<EventHandler> eventHandlers;

    @Override
    public void processAllTasks() {
        eventHandlers.forEach(EventHandler::handle);
    }

    public void setAdditionalEventHandlers(List<EventHandler> additionalEventHandlers) {
        this.eventHandlers = additionalEventHandlers;
    }
}
