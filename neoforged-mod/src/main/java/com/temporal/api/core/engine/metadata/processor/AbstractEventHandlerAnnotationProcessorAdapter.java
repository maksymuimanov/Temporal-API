package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.event.handler.EventHandler;

public abstract class AbstractEventHandlerAnnotationProcessorAdapter extends AbstractAnnotationProcessor implements EventHandler {
    @Override
    public void process() {
        this.handle();
    }
}
