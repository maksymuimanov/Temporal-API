package com.temporal.api.core.engine;

import com.temporal.api.ApiMod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;

import java.util.List;

public class TemporalEngine {
    public static LayerContainer run(Class<?> modClass, IEventBus eventBus, ModContainer modContainer) {
        synchronized (TemporalEngine.class) {
            ApiMod.LOGGER.info("Running TemporalEngine for : {}", modClass.getName());
            return defaultBuilder(modClass, eventBus, modContainer).build();
        }
    }

    public static EngineBuilder defaultBuilder(Class<?> modClass, IEventBus eventBus, ModContainer modContainer) {
        return emptyBuilder()
                .configureInitializationLayer()
                .modClass(modClass)
                .externalSource(List.of(eventBus, modContainer))
                .and()
                .configureRegistryLayer()
                .and()
                .configureMetadataLayer()
                .and()
                .configureEventLayer()
                .and()
                .configureConfigLayer()
                .and()
                .configureFinalizationLayer()
                .and();
    }

    public static EngineBuilder emptyBuilder() {
        return new EngineBuilder();
    }
}
