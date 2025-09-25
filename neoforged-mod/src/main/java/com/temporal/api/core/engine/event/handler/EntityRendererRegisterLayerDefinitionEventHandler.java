package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.collection.TemporalMap;
import com.temporal.api.core.engine.metadata.annotation.injection.Handler;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.util.Map;

@Handler(EntityRenderersEvent.RegisterLayerDefinitions.class)
public class EntityRendererRegisterLayerDefinitionEventHandler implements EventHandler {
    public static final Map<ModelLayerLocation, LayerDefinition> LAYERS = new TemporalMap<>();

    @Override
    public void handle() {
        this.subscribeModEvent(EntityRenderersEvent.RegisterLayerDefinitions.class, event -> {
            LAYERS.forEach((location, definition) -> event.registerLayerDefinition(location, () -> definition));
        });
    }
}
