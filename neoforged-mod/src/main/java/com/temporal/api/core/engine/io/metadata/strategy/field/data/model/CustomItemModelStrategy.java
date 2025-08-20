package com.temporal.api.core.engine.io.metadata.strategy.field.data.model;

import com.temporal.api.core.collection.SimplePair;
import com.temporal.api.core.engine.io.metadata.annotation.data.model.CustomItemModel;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.model.item.ItemModelDescriptionContainer;
import com.temporal.api.core.event.data.model.item.ItemModelProviderStrategy;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class CustomItemModelStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Holder<? extends Item> registryObject;
        if (field.get(object) instanceof DeferredBlock<?> deferredBlock) {
            registryObject = deferredBlock.asItem()
                    .getDefaultInstance()
                    .getItemHolder();
        } else {
            registryObject = (Holder<? extends Item>) field.get(object);
        }
        CustomItemModel itemModel = field.getDeclaredAnnotation(CustomItemModel.class);
        String[] additionalData = itemModel.additionalData();
        ItemModelProviderStrategy providerStrategy = itemModel.value()
                .getDeclaredConstructor()
                .newInstance();
        ItemModelDescriptionContainer.CUSTOM_MODELS.put(new SimplePair<>(registryObject, additionalData), providerStrategy);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return CustomItemModel.class;
    }
}
