package com.temporal.api.core.engine;

import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.engine.io.context.ObjectPoolCleaner;
import com.temporal.api.core.engine.io.context.ObjectPoolInitializer;
import com.temporal.api.core.engine.io.metadata.processor.AnnotationProcessor;

import java.util.List;

public class IOBuilder {
    private final EngineBuilder engineBuilder;
    private final IOLayer ioLayer;
    private Class<?> modClass;
    private List<ObjectPoolInitializer> initializers;
    private List<?> externalSource;
    private List<AnnotationProcessor<?>> simpleProcessors;
    private List<AnnotationProcessor<?>> asyncProcessors;
    private List<ObjectPoolCleaner> cleaners;

    protected IOBuilder(EngineBuilder engineBuilder) {
        this.engineBuilder = engineBuilder;
        this.ioLayer = new IOLayer();
        engineBuilder.addLayer(ioLayer);
    }

    public IOBuilder modClass(Class<?> modClass) {
        this.modClass = modClass;
        return this;
    }

    public IOBuilder initializers(List<ObjectPoolInitializer> initializers) {
        this.initializers = initializers;
        return this;
    }

    public IOBuilder externalSource(List<?> externalSource) {
        this.externalSource = externalSource;
        return this;
    }

    public IOBuilder simpleProcessors(List<AnnotationProcessor<?>> simpleProcessors) {
        this.simpleProcessors = simpleProcessors;
        return this;
    }

    public IOBuilder asyncProcessors(List<AnnotationProcessor<?>> asyncProcessors) {
        this.asyncProcessors = asyncProcessors;
        return this;
    }

    public IOBuilder cleaners(List<ObjectPoolCleaner> cleaners) {
        this.cleaners = cleaners;
        return this;
    }

    public EngineBuilder and() {
        EngineTask task = () -> {
            ioLayer.setModClass(modClass);
            ioLayer.setContextInitializers(initializers);
            ioLayer.setExternalSource(externalSource);
            ioLayer.setSimpleProcessors(simpleProcessors);
            ioLayer.setAsyncProcessors(asyncProcessors);
            ioLayer.setContextCleaners(cleaners);
            engineBuilder.processLayer(ioLayer);
        };
        engineBuilder.addTask(task);
        return engineBuilder;
    }
}
