package com.temporal.api.core.engine.metadata.strategy.type.event.layer;

import com.temporal.api.core.engine.event.handler.EntityRendererRegisterLayerDefinitionEventHandler;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.event.layer.RegisterLayerDefinition;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.strategy.type.ClassAnnotationStrategy;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;

@Strategy(StrategyPoolInitializer.DEFAULT_CLASS_EVENT_LAYER)
public class RegisterLayerDefinitionStrategy implements ClassAnnotationStrategy<RegisterLayerDefinition> {
    @Override
    public void execute(Class<?> clazz, Object object, RegisterLayerDefinition annotation) throws Exception {
        ModelLayerLocation modelLayerLocation = (ModelLayerLocation) clazz.getDeclaredField(annotation.fieldName()).get(object);
        LayerDefinition layerDefinition = (LayerDefinition) clazz.getDeclaredMethod(annotation.factoryMethodName()).invoke(object);
        EntityRendererRegisterLayerDefinitionEventHandler.LAYERS.put(modelLayerLocation, layerDefinition);
    }

    @Override
    public Class<? extends RegisterLayerDefinition> getAnnotationClass() {
        return RegisterLayerDefinition.class;
    }
}
