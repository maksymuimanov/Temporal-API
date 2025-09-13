package com.temporal.api.core.engine.finalization;

import com.temporal.api.core.engine.EngineBuilder;
import com.temporal.api.core.engine.finalization.cleaner.ObjectPoolCleaner;

import java.util.List;

public class FinalizationLayerBuilder {
    private static final List<ObjectPoolCleaner> DEFAULT_CLEANERS = List.of();
    private final EngineBuilder engineBuilder;
    private final FinalizationLayer finalizationLayer;
    private List<ObjectPoolCleaner> cleaners = DEFAULT_CLEANERS;

    public FinalizationLayerBuilder(EngineBuilder engineBuilder) {
        this.engineBuilder = engineBuilder;
        this.finalizationLayer = new FinalizationLayer();
        this.engineBuilder.addLayer(this.finalizationLayer);
    }

    public FinalizationLayerBuilder cleaners(List<ObjectPoolCleaner> cleaners) {
        this.cleaners = cleaners;
        return this;
    }

    public EngineBuilder and() {
        this.finalizationLayer.setContextCleaners(this.cleaners);
        this.engineBuilder.processLayer(this.finalizationLayer);
        return this.engineBuilder;
    }
}
