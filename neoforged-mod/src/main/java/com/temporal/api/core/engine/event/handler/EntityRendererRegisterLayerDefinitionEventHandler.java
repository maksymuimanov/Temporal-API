package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.collection.TemporalMap;
import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.engine.io.metadata.strategy.type.ClassAnnotationStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.type.event.RegisterLayerDefinitionStrategy;
import com.temporal.api.core.util.IOUtils;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

public class EntityRendererRegisterLayerDefinitionEventHandler implements EventHandler {
    public static final Map<ModelLayerLocation, LayerDefinition> LAYERS = new TemporalMap<>();
    private final Map<Class<? extends Annotation>, ClassAnnotationStrategy<?>> strategies = IOUtils.createAnnotationStrategyMap(List.of(
            new RegisterLayerDefinitionStrategy()
    ));

    @Override
    public void handle() {
        subscribeModEvent(EntityRenderersEvent.RegisterLayerDefinitions.class, event -> {
            IOLayer.ASYNC_STRATEGY_CONSUMER.execute(IOLayer.CLASS_EXECUTOR, strategies, IOLayer.NEO_MOD.getClasses());
            LAYERS.forEach((location, definition) -> event.registerLayerDefinition(location, () -> definition));
        });
    }
}
