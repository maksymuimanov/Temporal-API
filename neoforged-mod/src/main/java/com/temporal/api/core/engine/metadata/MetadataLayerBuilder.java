package com.temporal.api.core.engine.metadata;

import com.temporal.api.core.engine.EngineBuilder;
import com.temporal.api.core.engine.metadata.processor.AnnotationProcessor;

import java.util.List;

public class MetadataLayerBuilder {
    private static final List<AnnotationProcessor> DEFAULT_ANNOTATION_PROCESSORS = List.of();
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
        this.metadataLayer.setAnnotationProcessors(this.annotationProcessors);
        this.engineBuilder.processLayer(this.metadataLayer);
        return this.engineBuilder;
    }
}
