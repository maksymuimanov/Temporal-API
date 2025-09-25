package com.temporal.api.core.engine;

import com.temporal.api.ApiMod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;

import java.util.List;

public class TemporalEngine {
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

    public static LayerContainer run(Class<?> modClass, IEventBus eventBus, ModContainer modContainer) {
        synchronized (TemporalEngine.class) {
            System.out.println(BANNER);
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
                .configureConfigLayer()
                .and()
                .configureEventLayer()
                .and()
                .configureFinalizationLayer()
                .and();
    }

    public static EngineBuilder emptyBuilder() {
        return new EngineBuilder();
    }
}
