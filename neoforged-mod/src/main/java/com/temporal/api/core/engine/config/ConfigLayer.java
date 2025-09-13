package com.temporal.api.core.engine.config;

import com.temporal.api.core.engine.EngineLayer;
import com.temporal.api.core.engine.config.screen.ConfigShowcaser;

import java.util.List;

public class ConfigLayer implements EngineLayer {
    private List<ConfigShowcaser> configShowcasers;

    @Override
    public void processAllTasks() {
        configShowcasers.forEach(ConfigShowcaser::showcase);
    }

    public void setConfigShowcasers(List<ConfigShowcaser> configShowcasers) {
        this.configShowcasers = configShowcasers;
    }
}
