package com.temporal.api.core.engine;

import com.temporal.api.core.engine.event.handler.*;
import com.temporal.api.core.engine.io.context.*;
import com.temporal.api.core.engine.io.metadata.processor.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;

import java.util.Collections;
import java.util.List;

public class TemporalEngine {
    public static final List<ObjectPoolInitializer> DEFAULT_SIMPLE_INITIALIZERS = List.of(new DeferredRegisterPoolInitializer(), new FactoryPoolInitializer(), new EventBusPoolInitializer(), new ModContainerPoolInitializer());
    public static final List<AnnotationProcessor<?>> DEFAULT_SIMPLE_PROCESSORS = List.of(new ClassAnnotationProcessor(), new StaticFieldAnnotationProcessor(), new FieldAnnotationProcessor(), new MethodAnnotationProcessor());
    public static final List<EventHandler> DEFAULT_HANDLERS = List.of(new FMLClientSetupEventHandler(), new EntityRendererRegisterRendererEventHandler(), new EntityRendererRegisterLayerDefinitionEventHandler(), new DataEventHandler(), new FovModifierEventHandler());
    protected static final String BANNER = """
                       _________ _________ ___     ___ _________ _________ _________ _________ ____
                       ---- ---- |   ----| |  \\   / | |  ___  | |  ___  | |  ___  | |  ___  | |  |
                          | |    |  |      | | \\ /| | |  | |  | |  | |  | |  | |  | |  | |  | |  |
                          | |    |   --|   | |    | | |  | |  | |  | |  | |  |-|  | |  | |  | |  |
                          | |    |   --|   | |    | | |  -----| |  | |  | |   ---|  |  |-|  | |  |
                          | |    |  |      | |    | | | |       |  | |  | |  | |--| |  |-|  | |  |
                          | |    |  -----| | |    | | | |       |  ---  | |  | |  | |  | |  | |  -----|
                          |-|    --------| |-|    |-| |-|       --------- |--| |--| |--| |--| --------| v1.9.0
                    """;

    public static LayerContainer run(Class<?> modClass, IEventBus eventBus, ModContainer modContainer) {
        synchronized (TemporalEngine.class) {
            return builder()
                    .configureIOLayer()
                    .modClass(modClass)
                    .initializers(DEFAULT_SIMPLE_INITIALIZERS)
                    .externalSource(List.of(eventBus, modContainer))
                    .simpleProcessors(DEFAULT_SIMPLE_PROCESSORS)
                    .asyncProcessors(Collections.emptyList())
                    .cleaners(Collections.emptyList())
                    .and()
                    .configureEventLayer()
                    .handlers(DEFAULT_HANDLERS)
                    .and()
                    .build();
        }
    }

    public static EngineBuilder builder() {
        return new EngineBuilder();
    }
}
