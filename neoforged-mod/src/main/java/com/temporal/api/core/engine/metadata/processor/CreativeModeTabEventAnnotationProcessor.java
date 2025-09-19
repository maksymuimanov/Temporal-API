package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.event.handler.CreativeModeTabEventHandler;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.injection.Processor;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Processor(CreativeModeTabEventAnnotationProcessor.NAME)
public class CreativeModeTabEventAnnotationProcessor extends AbstractEventAnnotationProcessor {
    public static final String NAME = "default_creative_mode_tab_event";

    @Override
    public void handle() {
        this.subscribeModEvent(BuildCreativeModeTabContentsEvent.class, event -> {
            if (!CreativeModeTabEventHandler.CREATIVE_MODE_TABS_CONTENT.isEmpty()) return;
            this.processAll(MetadataLayer.ASYNC_STRATEGY_CONSUMER, ModContext.ALL_CLASSES);
        });
    }
}