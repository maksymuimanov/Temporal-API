package com.temporal.api.core.engine.metadata;

import com.temporal.api.core.engine.EngineBuilder;
import com.temporal.api.core.engine.EngineTask;
import com.temporal.api.core.engine.metadata.processor.AnnotationProcessor;
import com.temporal.api.core.engine.metadata.processor.ConfigAnnotationProcessor;

import java.util.List;

public class MetadataLayerBuilder {
    private static final List<AnnotationProcessor> DEFAULT_ANNOTATION_PROCESSORS = List.of(new ConfigAnnotationProcessor());
    private final EngineBuilder engineBuilder;
    private final MetadataLayer metadataLayer;
    private List<AnnotationProcessor> annotationProcessors = DEFAULT_ANNOTATION_PROCESSORS;

    public MetadataLayerBuilder(EngineBuilder engineBuilder) {
        this.engineBuilder = engineBuilder;
        this.metadataLayer = new MetadataLayer();
        this.engineBuilder.addLayer(this.metadataLayer);
    }

    public MetadataLayerBuilder annotationProcessors(List<AnnotationProcessor> simpleProcessors) {
        this.annotationProcessors = simpleProcessors;
        return this;
    }

    public EngineBuilder and() {
        EngineTask task = () -> {
            this.metadataLayer.setAnnotationProcessors(this.annotationProcessors);
            this.engineBuilder.processLayer(this.metadataLayer);
        };
        this.engineBuilder.addTask(task);
        return this.engineBuilder;
    }
}
