package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.injection.Processor;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@Processor(EntityRendererRegisterRendererEventAnnotationProcessor.NAME)
public class EntityRendererRegisterRendererEventAnnotationProcessor extends AbstractEventAnnotationProcessor {
    public static final String NAME = "default_entity_renderer_register_renderer_event";

    @Override
    public void handle() {
        this.subscribeModEvent(EntityRenderersEvent.RegisterRenderers.class, event -> {
            this.processAll(MetadataLayer.ASYNC_STRATEGY_CONSUMER, ModContext.ALL_CLASSES);
        });
    }
}