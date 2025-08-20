package com.temporal.api.core.engine.io.metadata.strategy.field.event.render;

import com.temporal.api.core.engine.event.handler.EntityRendererRegisterRendererEventHandler;
import com.temporal.api.core.engine.io.metadata.annotation.event.render.RegisterHangingSignRenderer;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class RegisterHangingSignRendererStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        var hangingSignBlockEntity = (DeferredHolder<BlockEntityType<?>, BlockEntityType<HangingSignBlockEntity>>) field.get(object);
        EntityRendererRegisterRendererEventHandler.RENDERING_REGISTRIES.add(event -> event.registerBlockEntityRenderer(hangingSignBlockEntity.value(), HangingSignRenderer::new));
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return RegisterHangingSignRenderer.class;
    }
}
