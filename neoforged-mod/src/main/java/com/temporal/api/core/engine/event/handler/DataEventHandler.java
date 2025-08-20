package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.engine.io.metadata.processor.AnnotationProcessor;
import com.temporal.api.core.engine.io.metadata.processor.DataClassAnnotationProcessor;
import com.temporal.api.core.engine.io.metadata.processor.DataFieldAnnotationProcessor;
import com.temporal.api.core.event.data.ApiDataGenerator;
import com.temporal.api.core.event.data.DataGatherer;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;

import static com.temporal.api.core.engine.io.IOLayer.ASYNC_STRATEGY_CONSUMER;
import static com.temporal.api.core.engine.io.IOLayer.NEO_MOD;

public class DataEventHandler implements EventHandler {
    private static final List<AnnotationProcessor<?>> DATA_PROCESSORS = List.of(new DataClassAnnotationProcessor(), new DataFieldAnnotationProcessor());
    private static final DataGatherer GENERATOR = new ApiDataGenerator();

    @Override
    public void handle() {
        subscribeModEvent(GatherDataEvent.class, event -> {
            DATA_PROCESSORS.forEach(annotationProcessor -> annotationProcessor.process(NEO_MOD.getClasses(), ASYNC_STRATEGY_CONSUMER));
            GENERATOR.gatherData(event);
        });
    }
}
