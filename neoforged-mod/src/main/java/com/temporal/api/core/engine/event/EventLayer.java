package com.temporal.api.core.engine.event;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.EngineLayer;
import com.temporal.api.core.engine.event.pool.HandlerPool;
import com.temporal.api.core.engine.event.pool.SimpleHandlerPool;

public class EventLayer implements EngineLayer {
    @Override
    public void processAllTasks() {
        HandlerPool handlerPool = SimpleHandlerPool.getInstance();
        ApiMod.LOGGER.debug("Processing dynamic {} eventClass handlers", handlerPool);
        handlerPool.forEach(eventHandler -> {
            ApiMod.LOGGER.debug("Processing dynamic eventHandler {}", eventHandler.getClass().getName());
            eventHandler.handle();
        });
    }
}
