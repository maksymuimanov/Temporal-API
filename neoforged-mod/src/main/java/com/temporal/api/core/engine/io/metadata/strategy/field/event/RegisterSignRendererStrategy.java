package com.temporal.api.core.engine.io.metadata.strategy.field.event;

import com.temporal.api.core.engine.event.handler.EntityRendererRegisterRendererEventHandler;
import com.temporal.api.core.engine.io.metadata.annotation.event.RegisterSignRenderer;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.lang.reflect.Field;

public class RegisterSignRendererStrategy implements FieldAnnotationStrategy<RegisterSignRenderer> {
    @Override
    public void execute(Field field, Object object, RegisterSignRenderer annotation) throws Exception {
        var signBlockEntity = (DeferredHolder<BlockEntityType<?>, BlockEntityType<SignBlockEntity>>) field.get(object);
        EntityRendererRegisterRendererEventHandler.RENDERING_REGISTRIES.add(event -> event.registerBlockEntityRenderer(signBlockEntity.value(), SignRenderer::new));
    }

    @Override
    public Class<? extends RegisterSignRenderer> getAnnotationClass() {
        return RegisterSignRenderer.class;
    }
}
