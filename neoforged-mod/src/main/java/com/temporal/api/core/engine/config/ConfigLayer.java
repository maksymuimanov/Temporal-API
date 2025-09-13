package com.temporal.api.core.engine.config;

import com.temporal.api.core.engine.EngineLayer;
import com.temporal.api.core.engine.config.screen.ConfigShowcaser;
import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.metadata.processor.AnnotationProcessor;
import com.temporal.api.core.engine.metadata.processor.ConfigAnnotationProcessor;

import java.util.List;

public class ConfigLayer implements EngineLayer {
    private static final AnnotationProcessor CONFIG_PROCESSOR = new ConfigAnnotationProcessor();
    private List<ConfigShowcaser> configShowcasers;

    @Override
    public void processAllTasks() {
        CONFIG_PROCESSOR.process(ModContext.NEO_MOD.getClasses());
        configShowcasers.forEach(ConfigShowcaser::showcase);
    }

    public void setConfigShowcasers(List<ConfigShowcaser> configShowcasers) {
        this.configShowcasers = configShowcasers;
    }
}
