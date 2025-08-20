package com.temporal.api.core.engine;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.io.IOLayer;

import java.util.ArrayList;
import java.util.List;

import static com.temporal.api.core.engine.TemporalEngine.BANNER;

public class EngineBuilder {
    private static final String LOAD_MESSAGE = "{} has been loaded!";
    private final LayerContainer layerContainer = LayerContainer.getInstance();
    private final List<EngineTask> tasks = new ArrayList<>(2);

    protected EngineBuilder() {
    }

    public EngineBuilder addLayer(EngineLayer engineLayer) {
        tasks.add(() -> layerContainer.add(engineLayer));
        return this;
    }

    public EngineBuilder disableLayer(Class<? extends EngineLayer> engineLayerClass) {
        tasks.add(() -> layerContainer.delete(engineLayerClass));
        return this;
    }
    
    public IOBuilder configureIOLayer() {
        return new IOBuilder(this);
    }

    public EventBuilder configureEventLayer() {
        return new EventBuilder(this);
    }

    public LayerContainer build() {
        System.out.println(BANNER);
        tasks.forEach(EngineTask::execute);
        ApiMod.LOGGER.info("Mod: {} has been registered as a TemporalEngine component!", IOLayer.NEO_MOD);
        return this.layerContainer;
    }

    protected void addTask(EngineTask task) {
        tasks.add(task);
    }
    
    protected void processLayer(EngineLayer engineLayer) {
        engineLayer.processAllTasks();
        ApiMod.LOGGER.info(LOAD_MESSAGE, engineLayer.getClass().getSimpleName());
    }
}
