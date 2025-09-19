package com.temporal.api.core.engine.metadata.processor;

import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.injection.Processor;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Processor(DataEventAnnotationProcessor.NAME)
public class DataEventAnnotationProcessor extends AbstractEventAnnotationProcessor {
    public static final String NAME = "default_data";

    @Override
    public void handle() {
        this.subscribeModEvent(GatherDataEvent.class, event -> {
            this.processAll(MetadataLayer.ASYNC_STRATEGY_CONSUMER, ModContext.NEO_MOD.getClasses());
        });
    }
}
