package com.temporal.api.core.engine.metadata.strategy.field.event.renderer;

import com.temporal.api.core.engine.event.handler.EntityRendererRegisterRendererEventHandler;
import com.temporal.api.core.engine.metadata.annotation.event.renderer.RegisterEntityRenderer;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class RegisterEntityRendererStrategy implements FieldAnnotationStrategy<RegisterEntityRenderer> {
    @Override
    public void execute(Field field, Object object, RegisterEntityRenderer annotation) throws Exception {
        Holder<? extends EntityType<? extends Entity>> entityTypeHolder = (Holder<EntityType<?>>) field.get(object);
        Class<? extends EntityRenderer<?>> rendererClass = annotation.value();
        Constructor<? extends EntityRenderer<?>> rendererConstructor = rendererClass.getDeclaredConstructor(EntityRendererProvider.Context.class);
        EntityRendererRegisterRendererEventHandler.RENDERING_REGISTRIES.add(event -> {
            event.registerEntityRenderer(entityTypeHolder.value(), context -> {
                try {
                    return (EntityRenderer<Entity>) rendererConstructor.newInstance(context);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        });
    }

    @Override
    public Class<? extends RegisterEntityRenderer> getAnnotationClass() {
        return RegisterEntityRenderer.class;
    }
}
