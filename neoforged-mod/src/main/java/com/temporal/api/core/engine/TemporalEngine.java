package com.temporal.api.core.engine;

import com.temporal.api.core.engine.event.handler.*;
import com.temporal.api.core.engine.io.context.*;
import com.temporal.api.core.engine.io.metadata.processor.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;

import java.util.Collections;
import java.util.List;

public class TemporalEngine {
    public static final List<ObjectPoolInitializer> DEFAULT_INITIALIZERS = List.of(new DeferredRegisterPoolInitializer(), new FactoryPoolInitializer(), new EventBusPoolInitializer(), new ModContainerPoolInitializer(), new InjectedObjectPoolInitializer());
    public static final List<FactoryRegistrar> DEFAULT_FACTORY_REGISTRARS = List.of(new FieldTypeFactoryRegistrar());
    public static final List<AnnotationProcessor<?>> DEFAULT_PROCESSORS = List.of(new ClassAnnotationProcessor(), new StaticFieldAnnotationProcessor(), new FieldAnnotationProcessor(), new MethodAnnotationProcessor());
    public static final List<EventHandler> DEFAULT_HANDLERS = List.of(new FMLClientSetupEventHandler(), new EntityRendererRegisterRendererEventHandler(), new EntityRendererRegisterLayerDefinitionEventHandler(), new DataEventHandler(), new FovModifierEventHandler(), new CreativeModeTabEventHandler());
    protected static final String BANNER = """
                       _________ _________ ___     ___ _________ _________ _________ _________ ____
                       ---- ---- |   ----| |  \\   / | |  ___  | |  ___  | |  ___  | |  ___  | |  |
                          | |    |  |      | | \\ /| | |  | |  | |  | |  | |  | |  | |  | |  | |  |
                          | |    |   --|   | |    | | |  | |  | |  | |  | |  |-|  | |  | |  | |  |
                          | |    |   --|   | |    | | |  -----| |  | |  | |   ---|  |  |-|  | |  |
                          | |    |  |      | |    | | | |       |  | |  | |  | |--| |  |-|  | |  |
                          | |    |  -----| | |    | | | |       |  ---  | |  | |  | |  | |  | |  -----|
                          |-|    --------| |-|    |-| |-|       --------- |--| |--| |--| |--| --------| v1.9.0 : by w4t3rcs :D
                    """;

    public static LayerContainer run(Class<?> modClass, IEventBus eventBus, ModContainer modContainer) {
        synchronized (TemporalEngine.class) {
            return defaultBuilder(modClass, eventBus, modContainer).build();
        }
    }

    public static EngineBuilder defaultBuilder(Class<?> modClass, IEventBus eventBus, ModContainer modContainer) {
        return defaultEventLayerBuilder(defaultIOLayerBuilder(emptyBuilder(), modClass, eventBus, modContainer).and()).and();
    }

    public static EventBuilder defaultEventLayerBuilder(EngineBuilder engineBuilder) {
        return engineBuilder.configureEventLayer()
                .handlers(DEFAULT_HANDLERS);
    }

    public static IOBuilder defaultIOLayerBuilder(EngineBuilder engineBuilder, Class<?> modClass, IEventBus eventBus, ModContainer modContainer) {
        return engineBuilder.configureIOLayer()
                .modClass(modClass)
                .initializers(DEFAULT_INITIALIZERS)
                .externalSource(List.of(eventBus, modContainer))
                .factoryRegistrars(DEFAULT_FACTORY_REGISTRARS)
                .simpleProcessors(DEFAULT_PROCESSORS)
                .asyncProcessors(Collections.emptyList())
                .cleaners(Collections.emptyList());
    }

    public static EngineBuilder emptyBuilder() {
        return new EngineBuilder();
    }
}
