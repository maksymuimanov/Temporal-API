package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.collection.TemporalMap;
import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.strategy.type.ClassAnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.type.event.RegisterLayerDefinitionStrategy;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

public class EntityRendererRegisterLayerDefinitionEventHandler implements EventHandler {
    public static final Map<ModelLayerLocation, LayerDefinition> LAYERS = new TemporalMap<>();
    private final Map<Class<? extends Annotation>, ClassAnnotationStrategy<?>> strategies = ReflectionUtils.createAnnotationStrategyMap(List.of(
            new RegisterLayerDefinitionStrategy()
    ));

    @Override
    public void handle() {
        subscribeModEvent(EntityRenderersEvent.RegisterLayerDefinitions.class, event -> {
            MetadataLayer.ASYNC_STRATEGY_CONSUMER.execute(MetadataLayer.CLASS_EXECUTOR, strategies, ModContext.NEO_MOD.getClasses());
            LAYERS.forEach((location, definition) -> event.registerLayerDefinition(location, () -> definition));
        });
    }
}
