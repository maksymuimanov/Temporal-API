package com.temporal.api.core.engine.metadata.annotation.event.renderer;

import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RegisterBlockEntityRenderer {
    Class<? extends BlockEntityRenderer<?>> value();
}