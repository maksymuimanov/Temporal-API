package com.temporal.api.core.engine.event.handler;

import com.temporal.api.core.collection.TemporalMap;
import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.injection.Handler;
import com.temporal.api.core.engine.metadata.pool.SimpleStrategyPool;
import com.temporal.api.core.engine.metadata.strategy.type.ClassAnnotationStrategy;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.lang.annotation.Annotation;
import java.util.Map;

@Handler(EntityRenderersEvent.RegisterLayerDefinitions.class)
public class EntityRendererRegisterLayerDefinitionEventHandler implements EventHandler {
    public static final Map<ModelLayerLocation, LayerDefinition> LAYERS = new TemporalMap<>();

    @Override
    public void handle() {
        this.subscribeModEvent(EntityRenderersEvent.RegisterLayerDefinitions.class, event -> {
            Map<Class<? extends Annotation>, ClassAnnotationStrategy<?>> strategies = SimpleStrategyPool.getInstance().getAll(StrategyPoolInitializer.DEFAULT_CLASS_EVENT_LAYER);
            MetadataLayer.ASYNC_STRATEGY_CONSUMER.execute(MetadataLayer.CLASS_EXECUTOR, strategies, ModContext.ALL_CLASSES);
            LAYERS.forEach((location, definition) -> event.registerLayerDefinition(location, () -> definition));
        });
    }
}
