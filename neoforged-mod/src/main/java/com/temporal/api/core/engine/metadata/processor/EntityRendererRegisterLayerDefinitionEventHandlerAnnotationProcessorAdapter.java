package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.injection.Processor;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@Processor(EntityRendererRegisterLayerDefinitionEventHandlerAnnotationProcessorAdapter.NAME)
public class EntityRendererRegisterLayerDefinitionEventHandlerAnnotationProcessorAdapter extends AbstractEventHandlerAnnotationProcessorAdapter {
    public static final String NAME = "default_entity_renderer_register_layer_definition_event";

    @Override
    public void handle() {
        this.subscribeModEvent(EntityRenderersEvent.RegisterLayerDefinitions.class, event -> {
            this.processAll(MetadataLayer.ASYNC_STRATEGY_CONSUMER, ModContext.ALL_CLASSES);
        }, EventPriority.HIGHEST);
    }
}