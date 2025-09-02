package com.temporal.api.core.engine.event;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.EngineLayer;
import com.temporal.api.core.engine.event.handler.EventHandler;

import java.util.List;

public class EventLayer implements EngineLayer {
    private List<EventHandler> eventHandlers;

    @Override
    public void processAllTasks() {
        ApiMod.LOGGER.debug("Processing {} event handlers", eventHandlers.size());
        eventHandlers.forEach(eventHandler -> {
            ApiMod.LOGGER.debug("Processing eventHandler {}", eventHandler.getClass().getName());
            eventHandler.handle();
        });
    }

    public void setAdditionalEventHandlers(List<EventHandler> additionalEventHandlers) {
        this.eventHandlers = additionalEventHandlers;
    }
}
