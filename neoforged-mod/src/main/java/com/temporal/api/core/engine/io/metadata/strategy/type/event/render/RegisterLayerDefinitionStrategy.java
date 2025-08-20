package com.temporal.api.core.engine.io.metadata.strategy.type.event.render;

import com.temporal.api.core.engine.event.handler.EntityRendererRegisterLayerDefinitionEventHandler;
import com.temporal.api.core.engine.io.metadata.annotation.event.render.RegisterLayerDefinition;
import com.temporal.api.core.engine.io.metadata.strategy.type.ClassAnnotationStrategy;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;

import java.lang.annotation.Annotation;

public class RegisterLayerDefinitionStrategy implements ClassAnnotationStrategy {
    @Override
    public void execute(Class<?> clazz, Object object) throws Exception {
        RegisterLayerDefinition annotation = clazz.getDeclaredAnnotation(RegisterLayerDefinition.class);
        ModelLayerLocation modelLayerLocation = (ModelLayerLocation) clazz.getDeclaredField(annotation.layerLocationFieldName()).get(object);
        LayerDefinition layerDefinition = (LayerDefinition) clazz.getDeclaredMethod(annotation.layerLocationFieldName()).invoke(object);
        EntityRendererRegisterLayerDefinitionEventHandler.LAYERS.put(modelLayerLocation, layerDefinition);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return RegisterLayerDefinition.class;
    }
}
