package com.temporal.api.core.engine.metadata;

import com.temporal.api.core.engine.EngineBuilder;
import com.temporal.api.core.engine.EngineTask;
import com.temporal.api.core.engine.metadata.processor.*;

import java.util.List;

public class MetadataLayerBuilder {
    private static final List<AnnotationProcessor<?>> DEFAULT_SIMPLE_PROCESSORS = List.of(new ClassAnnotationProcessor(), new StaticFieldAnnotationProcessor(), new FieldAnnotationProcessor(), new MethodAnnotationProcessor());
    private static final List<AnnotationProcessor<?>> DEFAULT_ASYNC_PROCESSORS = List.of();
    private final EngineBuilder engineBuilder;
    private final MetadataLayer metadataLayer;
    private List<AnnotationProcessor<?>> simpleProcessors = DEFAULT_SIMPLE_PROCESSORS;
    private List<AnnotationProcessor<?>> asyncProcessors = DEFAULT_ASYNC_PROCESSORS;

    public MetadataLayerBuilder(EngineBuilder engineBuilder) {
        this.engineBuilder = engineBuilder;
        this.metadataLayer = new MetadataLayer();
        this.engineBuilder.addLayer(this.metadataLayer);
    }

    public MetadataLayerBuilder simpleProcessors(List<AnnotationProcessor<?>> simpleProcessors) {
        this.simpleProcessors = simpleProcessors;
        return this;
    }

    public MetadataLayerBuilder asyncProcessors(List<AnnotationProcessor<?>> asyncProcessors) {
        this.asyncProcessors = asyncProcessors;
        return this;
    }

    public EngineBuilder and() {
        EngineTask task = () -> {
            this.metadataLayer.setSimpleProcessors(this.simpleProcessors);
            this.metadataLayer.setAsyncProcessors(this.asyncProcessors);
            this.engineBuilder.processLayer(this.metadataLayer);
        };
        this.engineBuilder.addTask(task);
        return this.engineBuilder;
    }
}
