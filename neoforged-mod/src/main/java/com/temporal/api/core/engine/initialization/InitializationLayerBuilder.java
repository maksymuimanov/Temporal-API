package com.temporal.api.core.engine.initialization;

import com.temporal.api.core.engine.EngineBuilder;
import com.temporal.api.core.engine.initialization.initializer.*;
import com.temporal.api.core.engine.initialization.scanner.ClasspathModClassScanner;
import com.temporal.api.core.engine.initialization.scanner.ModClassScanner;

import java.util.List;

public class InitializationLayerBuilder {
    private static final List<ModClassScanner> DEFAULT_CLASS_SCANNERS = List.of(new ClasspathModClassScanner());
    private static final List<ObjectPoolInitializer> DEFAULT_INITIALIZERS = List.of(new TemporalRegisterPoolInitializer(), new FactoryPoolInitializer(), new EventBusPoolInitializer(), new ModContainerPoolInitializer(), new InjectedObjectPoolInitializer(), new StrategyPoolInitializer(), new HandlerPoolInitializer());
    private final EngineBuilder engineBuilder;
    private final InitializationLayer initializationLayer;
    private Class<?> modClass;
    private List<ModClassScanner> classScanners = DEFAULT_CLASS_SCANNERS;
    private List<ObjectPoolInitializer> initializers = DEFAULT_INITIALIZERS;
    private List<?> externalSource;

    public InitializationLayerBuilder(EngineBuilder engineBuilder) {
        this.engineBuilder = engineBuilder;
        this.initializationLayer = new InitializationLayer();
        this.engineBuilder.addLayer(this.initializationLayer);
    }

    public InitializationLayerBuilder modClass(Class<?> modClass) {
        this.modClass = modClass;
        return this;
    }

    public InitializationLayerBuilder classScanners(List<ModClassScanner> classScanners) {
        this.classScanners = classScanners;
        return this;
    }

    public InitializationLayerBuilder initializers(List<ObjectPoolInitializer> initializers) {
        this.initializers = initializers;
        return this;
    }

    public InitializationLayerBuilder externalSource(List<?> externalSource) {
        this.externalSource = externalSource;
        return this;
    }

    public EngineBuilder and() {
        this.initializationLayer.setModClass(this.modClass);
        this.initializationLayer.setClassScanners(this.classScanners);
        this.initializationLayer.setContextInitializers(this.initializers);
        this.initializationLayer.setExternalSource(this.externalSource);
        this.engineBuilder.processLayer(this.initializationLayer);
        return this.engineBuilder;
    }
}
