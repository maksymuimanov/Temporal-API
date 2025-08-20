package net.temporal.example;

import com.temporal.api.ApiMod;
import com.temporal.api.core.compat.AsyncDependencyProcessBuilder;
import com.temporal.api.core.compat.DependencyFunction;
import com.temporal.api.core.compat.SimpleDependencyProcessBuilder;
import com.temporal.api.core.engine.TemporalEngine;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(ExampleMod.MOD_ID)
public class ExampleMod {
    public static final String MOD_ID = "example";

    public ExampleMod(IEventBus modEventBus, ModContainer modContainer) {
        TemporalEngine.run(ExampleMod.class, modEventBus, modContainer);
        //If there is a mod with "temporalapi" mod id, it will log "hello", "world :D"
        SimpleDependencyProcessBuilder.create("temporalapi")
                .addProcess((DependencyFunction) () -> ApiMod.LOGGER.info("hello"))
                .addProcess((DependencyFunction) () -> ApiMod.LOGGER.info("world :D"))
                .build();
        //If there is a mod with "temporalapi" mod id, it will log "1", "2", ... in different threads
        AsyncDependencyProcessBuilder.create("temporalapi")
                .addProcess((DependencyFunction) () -> ApiMod.LOGGER.info("I am async: 1"))
                .addProcess((DependencyFunction) () -> ApiMod.LOGGER.info("I am async: 2"))
                .addProcess((DependencyFunction) () -> ApiMod.LOGGER.info("I am async: 3"))
                .addProcess((DependencyFunction) () -> ApiMod.LOGGER.info("I am async: 4"))
                .addProcess((DependencyFunction) () -> ApiMod.LOGGER.info("I am async: 5"))
                .addProcess((DependencyFunction) () -> ApiMod.LOGGER.info("I am async: 6"))
                .addProcess((DependencyFunction) () -> ApiMod.LOGGER.info("I am async: 7"))
                .addProcess((DependencyFunction) () -> ApiMod.LOGGER.info("I am async: 8"))
                .addProcess((DependencyFunction) () -> ApiMod.LOGGER.info("I am async: 9"))
                .addProcess((DependencyFunction) () -> ApiMod.LOGGER.info("I am async: 10"))
                .build();


        NeoForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
