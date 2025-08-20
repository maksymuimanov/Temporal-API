package com.temporal.api.core.engine.io.metadata.strategy.field.data.model;

import com.temporal.api.core.collection.SimplePair;
import com.temporal.api.core.engine.io.metadata.annotation.data.model.CustomBlockModel;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.model.block.BlockModelDescriptionContainer;
import com.temporal.api.core.event.data.model.block.BlockModelProviderStrategy;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class CustomBlockModelStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Holder<? extends Block> registryObject = (Holder<? extends Block>) field.get(object);
        CustomBlockModel blockModel = field.getDeclaredAnnotation(CustomBlockModel.class);
        String[] additionalData = blockModel.additionalData();
        BlockModelProviderStrategy providerStrategy = blockModel.value()
                .getDeclaredConstructor()
                .newInstance();
        BlockModelDescriptionContainer.CUSTOM_MODELS.put(new SimplePair<>(registryObject, additionalData), providerStrategy);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return CustomBlockModel.class;
    }
}
