package com.temporal.api.core.engine.metadata.strategy.field.event.renderer;

import com.temporal.api.core.engine.event.handler.EntityRendererRegisterRendererEventHandler;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.event.renderer.RegisterBlockEntityRenderer;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.EntityRendererRegisterRendererEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_EVENT_RENDERER)
public class RegisterBlockEntityRendererStrategy implements FieldAnnotationStrategy<RegisterBlockEntityRenderer> {
    @Override
    @SuppressWarnings("unchecked")
    public void execute(Field field, Object object, RegisterBlockEntityRenderer annotation) throws Exception {
        Holder<? extends BlockEntityType<? extends BlockEntity>> blockEntityType = ReflectionUtils.getFieldValue(field, object);
        Class<? extends BlockEntityRenderer<?>> rendererClass = annotation.value();
        Constructor<? extends BlockEntityRenderer<?>> rendererConstructor = rendererClass.getDeclaredConstructor(rendererClass);
        EntityRendererRegisterRendererEventHandler.RENDERING_REGISTRIES.add(event -> {
            event.registerBlockEntityRenderer(blockEntityType.value(), context -> {
                try {
                    return (BlockEntityRenderer<BlockEntity>) rendererConstructor.newInstance(context);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        });
    }

    @Override
    public Class<RegisterBlockEntityRenderer> getAnnotationClass() {
        return RegisterBlockEntityRenderer.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(EntityRendererRegisterRendererEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
