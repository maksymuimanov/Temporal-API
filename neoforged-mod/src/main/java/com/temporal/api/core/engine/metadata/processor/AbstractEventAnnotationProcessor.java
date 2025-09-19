package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.event.handler.EventHandler;

public abstract class AbstractEventAnnotationProcessor extends AbstractAnnotationProcessor implements EventHandler {
    @Override
    public void process() {
        this.handle();
    }

    @Override
    public int getPriority() {
        return EventHandler.MAX_PRIORITY;
    }
}
