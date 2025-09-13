package com.temporal.api.core.engine.config;

import com.temporal.api.core.engine.EngineBuilder;
import com.temporal.api.core.engine.EngineTask;
import com.temporal.api.core.engine.config.screen.ConfigShowcaser;
import com.temporal.api.core.engine.config.screen.SimpleConfigShowcaser;

import java.util.List;

public class ConfigLayerBuilder {
    private static final List<ConfigShowcaser> DEFAULT_CONFIG_SHOWCASERS = List.of(new SimpleConfigShowcaser());
    private final EngineBuilder engineBuilder;
    private final ConfigLayer configLayer;
    private List<ConfigShowcaser> configShowcasers = DEFAULT_CONFIG_SHOWCASERS;

    public ConfigLayerBuilder(EngineBuilder engineBuilder) {
        this.engineBuilder = engineBuilder;
        this.configLayer = new ConfigLayer();
        this.engineBuilder.addLayer(this.configLayer);
    }

    public ConfigLayerBuilder configShowcasers(List<ConfigShowcaser> configShowcasers) {
        this.configShowcasers = configShowcasers;
        return this;
    }

    public EngineBuilder and() {
        EngineTask task = () -> {
            this.configLayer.setConfigShowcasers(this.configShowcasers);
            this.engineBuilder.processLayer(this.configLayer);
        };
        this.engineBuilder.addTask(task);
        return this.engineBuilder;
    }
}
