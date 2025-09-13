package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.event.data.ApiDataGenerator;
import com.temporal.api.core.engine.event.data.DataGatherer;
import com.temporal.api.core.engine.metadata.annotation.injection.Handler;
import com.temporal.api.core.engine.metadata.processor.AnnotationProcessor;
import com.temporal.api.core.engine.metadata.processor.DataAnnotationProcessor;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Handler(GatherDataEvent.class)
public class DataEventHandler implements EventHandler {
    private static final AnnotationProcessor DATA_ANNOTATION_PROCESSOR = new DataAnnotationProcessor();
    private static final DataGatherer GENERATOR = new ApiDataGenerator();

    @Override
    public void handle() {
        this.subscribeModEvent(GatherDataEvent.class, event -> {
            DATA_ANNOTATION_PROCESSOR.process(ModContext.NEO_MOD.getClasses());
            GENERATOR.gatherData(event);
        });
    }
}
