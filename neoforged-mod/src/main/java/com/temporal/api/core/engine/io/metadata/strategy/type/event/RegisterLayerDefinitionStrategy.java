package com.temporal.api.core.engine.io.metadata.strategy.type.event;

import com.temporal.api.core.engine.event.handler.EntityRendererRegisterLayerDefinitionEventHandler;
import com.temporal.api.core.engine.io.metadata.annotation.event.RegisterLayerDefinition;
import com.temporal.api.core.engine.io.metadata.strategy.type.ClassAnnotationStrategy;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;

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
