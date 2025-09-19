package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.injection.Processor;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Processor(FMLClientSetupEventAnnotationProcessor.NAME)
public class FMLClientSetupEventAnnotationProcessor extends AbstractEventAnnotationProcessor {
    public static final String NAME = "default_fml_client_setup_event";

    @Override
    public void handle() {
        this.subscribeModEvent(FMLClientSetupEvent.class, event -> {
            this.processAll(MetadataLayer.ASYNC_STRATEGY_CONSUMER, ModContext.ALL_CLASSES);
        });
    }
}