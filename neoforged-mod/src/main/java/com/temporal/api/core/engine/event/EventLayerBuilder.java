package com.temporal.api.core.engine.event;

import com.temporal.api.core.engine.EngineBuilder;
import com.temporal.api.core.engine.EngineTask;
import com.temporal.api.core.engine.event.handler.*;

import java.util.List;

public class EventLayerBuilder {
    private static final List<EventHandler> DEFAULT_EVENT_HANDLERS = List.of(new FMLClientSetupEventHandler(), new EntityAttributeEventHandler(), new EntityRendererRegisterRendererEventHandler(), new EntityRendererRegisterLayerDefinitionEventHandler(), new DataEventHandler(), new FovModifierEventHandler(), new CreativeModeTabEventHandler(), new BlockEntityTypeEventHandler());
    private final EngineBuilder engineBuilder;
    private final EventLayer eventLayer;
    private List<EventHandler> eventHandlers = DEFAULT_EVENT_HANDLERS;

    public EventLayerBuilder(EngineBuilder engineBuilder) {
        this.engineBuilder = engineBuilder;
        this.eventLayer = new EventLayer();
        this.engineBuilder.addLayer(this.eventLayer);
    }

    public EventLayerBuilder eventHandlers(List<EventHandler> eventHandlers) {
        this.eventHandlers = eventHandlers;
        return this;
    }

    public EngineBuilder and() {
        EngineTask eventSetupTask = () -> {
            this.eventLayer.setEventHandlers(eventHandlers);
            this.engineBuilder.processLayer(eventLayer);
        };

        this.engineBuilder.addTask(eventSetupTask);
        return this.engineBuilder;
    }
}
