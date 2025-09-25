package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.injection.Processor;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@Processor(EntityAttributeEventHandlerAnnotationProcessorAdapter.NAME)
public class EntityAttributeEventHandlerAnnotationProcessorAdapter extends AbstractEventHandlerAnnotationProcessorAdapter {
    public static final String NAME = "default_entity_attribute_event";

    @Override
    public void handle() {
        this.subscribeModEvent(EntityAttributeCreationEvent.class, event -> {
            this.processAll(MetadataLayer.ASYNC_STRATEGY_CONSUMER, ModContext.ALL_CLASSES);
        }, EventPriority.HIGHEST);
    }
}