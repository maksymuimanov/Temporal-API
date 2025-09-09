package com.temporal.api.core.engine.event;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.EngineLayer;
import com.temporal.api.core.engine.event.handler.EventHandler;
import com.temporal.api.core.engine.event.pool.EventHandlerPool;
import com.temporal.api.core.engine.event.pool.SimpleEventHandlerPool;

import java.util.List;

public class EventLayer implements EngineLayer {
    private List<EventHandler> eventHandlers;

    @Override
    public void processAllTasks() {
        ApiMod.LOGGER.debug("Processing defaulted {} event handlers", eventHandlers.size());
        eventHandlers.forEach(eventHandler -> {
            ApiMod.LOGGER.debug("Processing defaulted eventHandler {}", eventHandler.getClass().getName());
            eventHandler.handle();
        });
        EventHandlerPool eventHandlerPool = SimpleEventHandlerPool.getInstance();
        ApiMod.LOGGER.debug("Processing dynamic {} event handlers", eventHandlerPool);
        eventHandlerPool.forEach(eventHandler -> {
            ApiMod.LOGGER.debug("Processing dynamic eventHandler {}", eventHandler.getClass().getName());
            eventHandler.handle();
        });
    }

    public void setEventHandlers(List<EventHandler> eventHandlers) {
        this.eventHandlers = eventHandlers;
    }
}
