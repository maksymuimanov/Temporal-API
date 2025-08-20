package com.temporal.api.core.engine.io.metadata.strategy.field.data.model;

import com.temporal.api.core.engine.io.metadata.annotation.data.model.ItemModel;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.model.item.ItemModelDescriptionContainer;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ItemModelStrategy implements FieldAnnotationStrategy {
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
        ItemModel itemModel = field.getDeclaredAnnotation(ItemModel.class);
        String[] additionalData = itemModel.additionalData();
        switch (itemModel.value()) {
            case BASIC -> ItemModelDescriptionContainer.BASIC_ITEMS.put(registryObject, additionalData);
            case HANDHELD -> ItemModelDescriptionContainer.HANDHELD_ITEMS.put(registryObject, additionalData);
            case BOW -> ItemModelDescriptionContainer.BOW_ITEMS.put(registryObject, additionalData);
            case CROSSBOW -> ItemModelDescriptionContainer.CROSSBOW_ITEMS.put(registryObject, additionalData);
            case TRIMMED_ARMOR -> ItemModelDescriptionContainer.TRIMMED_ARMOR_ITEMS.put(registryObject, additionalData);
            case POTION -> ItemModelDescriptionContainer.POTION_ITEMS.put(registryObject, additionalData);
            case BLOCK -> ItemModelDescriptionContainer.BLOCK_ITEMS.put(registryObject, additionalData);
        }
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return ItemModel.class;
    }
}
