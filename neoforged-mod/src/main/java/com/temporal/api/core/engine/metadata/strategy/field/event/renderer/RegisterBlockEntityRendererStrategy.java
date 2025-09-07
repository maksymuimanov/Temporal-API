package com.temporal.api.core.engine.metadata.strategy.field.event.renderer;

import com.temporal.api.core.engine.event.handler.EntityRendererRegisterRendererEventHandler;
import com.temporal.api.core.engine.metadata.annotation.event.renderer.RegisterBlockEntityRenderer;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class RegisterBlockEntityRendererStrategy implements FieldAnnotationStrategy<RegisterBlockEntityRenderer> {
    @Override
    public void execute(Field field, Object object, RegisterBlockEntityRenderer annotation) throws Exception {
        Holder<? extends BlockEntityType<? extends BlockEntity>> blockEntityTypeHolder = (Holder<? extends BlockEntityType<?>>) field.get(object);
        Class<? extends BlockEntityRenderer<?>> rendererClass = annotation.value();
        Constructor<? extends BlockEntityRenderer<?>> rendererConstructor = rendererClass.getDeclaredConstructor(rendererClass);
        EntityRendererRegisterRendererEventHandler.RENDERING_REGISTRIES.add(event -> {
            event.registerBlockEntityRenderer(blockEntityTypeHolder.value(), context -> {
                try {
                    return (BlockEntityRenderer<BlockEntity>) rendererConstructor.newInstance(context);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        });
    }

    @Override
    public Class<? extends RegisterBlockEntityRenderer> getAnnotationClass() {
        return RegisterBlockEntityRenderer.class;
    }
}
