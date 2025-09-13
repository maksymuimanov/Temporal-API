package com.temporal.api.core.engine;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.config.ConfigLayerBuilder;
import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.event.EventLayerBuilder;
import com.temporal.api.core.engine.finalization.FinalizationLayerBuilder;
import com.temporal.api.core.engine.initialization.InitializationLayerBuilder;
import com.temporal.api.core.engine.metadata.MetadataLayerBuilder;
import com.temporal.api.core.engine.registry.RegistryLayerBuilder;

import java.util.ArrayList;
import java.util.List;

public class EngineBuilder {
    protected static final String BANNER = """
                       .__________. ._______. .__     __. ._______. ._______. ._______. ._______. .__.
                       |----  ----| |   ----| |  \\   /  | |  ___  | |  ___  | |  ___  | |  ___  | |  |
                           |  |     |  |      | | \\ / | | |  | |  | |  | |  | |  | |  | |  | |  | |  |
                           |  |     |   --|   | |     | | |  | |  | |  | |  | |  |-|  | |  | |  | |  |
                           |  |     |   --|   | |     | | |  -----| |  | |  | |   .--|  |  |-|  | |  |
                           |  |     |  |      | |     | | | |       |  | |  | |  | |--| |  |-|  | |  |
                           |  |     |  -----| | |     | | | |       |  ---  | |  | |  | |  | |  | |  -----|
                           |--|     |-------| |-|     |-| |-|       |-------| |--| |--| |--| |--| |-------| v1.9.0 by w4t3rcs :D
                    """;
    private static final int DEFAULT_LAYER_COUNT = 6;
    private final LayerContainer layerContainer = LayerContainer.getInstance();
    private final List<EngineTask> tasks = new ArrayList<>(DEFAULT_LAYER_COUNT);

    protected EngineBuilder() {
    }

    public EngineBuilder addLayer(EngineLayer engineLayer) {
        this.tasks.add(() -> this.layerContainer.add(engineLayer));
        return this;
    }

    public EngineBuilder disableLayer(Class<? extends EngineLayer> engineLayerClass) {
        this.tasks.add(() -> this.layerContainer.delete(engineLayerClass));
        return this;
    }
    
    public InitializationLayerBuilder configureInitializationLayer() {
        return new InitializationLayerBuilder(this);
    }

    public RegistryLayerBuilder configureRegistryLayer() {
        return new RegistryLayerBuilder(this);
    }

    public MetadataLayerBuilder configureMetadataLayer() {
        return new MetadataLayerBuilder(this);
    }

    public EventLayerBuilder configureEventLayer() {
        return new EventLayerBuilder(this);
    }

    public ConfigLayerBuilder configureConfigLayer() {
        return new ConfigLayerBuilder(this);
    }

    public FinalizationLayerBuilder configureFinalizationLayer() {
        return new FinalizationLayerBuilder(this);
    }

    public LayerContainer build() {
        System.out.println(BANNER);
        this.tasks.forEach(EngineTask::execute);
        ApiMod.LOGGER.info("Mod: {} has been registered as a TemporalEngine component!", ModContext.NEO_MOD.getModId());
        return this.layerContainer;
    }

    public void addTask(EngineTask task) {
        this.tasks.add(task);
    }
    
    public void processLayer(EngineLayer engineLayer) {
        String layerName = engineLayer.getClass().getName();
        ApiMod.LOGGER.info("Layer: {} is going to be processed!", layerName);
        engineLayer.processAllTasks();
        ApiMod.LOGGER.info("Layer: {} has been processed!", layerName);
    }
}
