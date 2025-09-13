package com.temporal.api.core.engine.config;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.EngineLayer;
import com.temporal.api.core.engine.config.screen.ConfigShowcaser;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.context.ObjectPool;
import com.temporal.api.core.engine.metadata.processor.AnnotationProcessor;
import com.temporal.api.core.engine.metadata.processor.ConfigAnnotationProcessor;

import java.util.List;

public class ConfigLayer implements EngineLayer {
    private static final AnnotationProcessor CONFIG_PROCESSOR = new ConfigAnnotationProcessor();
    private List<ConfigShowcaser> configShowcasers;

    @Override
    public void processAllTasks() {
        ApiMod.LOGGER.debug("Processing ConfigAnnotationProcessor");
        CONFIG_PROCESSOR.process(ModContext.NEO_MOD.getClasses());
        this.configShowcasers.forEach(configShowcaser -> {
            ApiMod.LOGGER.debug("Running defaulted ConfigShowcaser - {}", configShowcaser.getClass().getName());
            configShowcaser.showcase();
        });
        ObjectPool objectPool = InjectionPool.getInstance();
        objectPool.getAll(ConfigShowcaser.class).forEach(configShowcaser -> {
            ApiMod.LOGGER.debug("Running dynamic ConfigShowcaser - {}", configShowcaser.getClass().getName());
            configShowcaser.showcase();
        });
    }

    public void setConfigShowcasers(List<ConfigShowcaser> configShowcasers) {
        this.configShowcasers = configShowcasers;
    }
}
