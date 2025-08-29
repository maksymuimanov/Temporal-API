package com.temporal.api.core.engine.io.metadata.strategy.field.event;

import com.temporal.api.core.engine.event.handler.EntityRendererRegisterRendererEventHandler;
import com.temporal.api.core.engine.io.metadata.annotation.event.RegisterHangingSignRenderer;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;

import java.lang.reflect.Field;

public class RegisterHangingSignRendererStrategy implements FieldAnnotationStrategy<RegisterHangingSignRenderer> {
    @Override
    public void execute(Field field, Object object, RegisterHangingSignRenderer annotation) throws Exception {
        var hangingSignBlockEntity = (Holder<BlockEntityType<HangingSignBlockEntity>>) field.get(object);
        EntityRendererRegisterRendererEventHandler.RENDERING_REGISTRIES.add(event -> event.registerBlockEntityRenderer(hangingSignBlockEntity.value(), HangingSignRenderer::new));
    }

    @Override
    public Class<? extends RegisterHangingSignRenderer> getAnnotationClass() {
        return RegisterHangingSignRenderer.class;
    }
}
