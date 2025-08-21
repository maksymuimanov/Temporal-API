package com.temporal.api.core.engine.io.metadata.strategy.field.data.model;

import com.temporal.api.core.collection.SimplePair;
import com.temporal.api.core.engine.io.metadata.annotation.data.model.GenerateItemModel;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.model.item.ItemModelDescriptionContainer;
import com.temporal.api.core.event.data.model.item.ItemModelProviderStrategy;
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
        GenerateItemModel annotation = field.getDeclaredAnnotation(GenerateItemModel.class);
        String[] additionalData = annotation.additionalData();
        if (!ItemModelProviderStrategy.class.equals(annotation.custom())) {
            ItemModelProviderStrategy providerStrategy = annotation.custom()
                    .getDeclaredConstructor()
                    .newInstance();
            ItemModelDescriptionContainer.CUSTOM_MODELS.put(new SimplePair<>(registryObject, additionalData), providerStrategy);
            return;
        }
        switch (annotation.value()) {
            case BASIC -> ItemModelDescriptionContainer.BASIC_ITEMS.put(registryObject, additionalData);
            case HANDHELD -> ItemModelDescriptionContainer.HANDHELD_ITEMS.put(registryObject, additionalData);
            case BOW -> ItemModelDescriptionContainer.BOW_ITEMS.put(registryObject, additionalData);
            case CROSSBOW -> ItemModelDescriptionContainer.CROSSBOW_ITEMS.put(registryObject, additionalData);
            case TRIMMED_ARMOR -> ItemModelDescriptionContainer.TRIMMED_ARMOR_ITEMS.put(registryObject, additionalData);
            case POTION -> ItemModelDescriptionContainer.POTION_ITEMS.put(registryObject, additionalData);
            case CUBED -> ItemModelDescriptionContainer.CUBED_BLOCK_ITEMS.put(registryObject, additionalData);
            case BLOCK_FLAT -> ItemModelDescriptionContainer.BLOCK_FLAT_BLOCK_ITEMS.put(registryObject, additionalData);
            case LOG -> ItemModelDescriptionContainer.LOG_BLOCK_ITEMS.put(registryObject, additionalData);
            case WOOD -> ItemModelDescriptionContainer.WOOD_BLOCK_ITEMS.put(registryObject, additionalData);
            case BUTTON -> ItemModelDescriptionContainer.BUTTON_BLOCK_ITEMS.put(registryObject, additionalData);
            case FENCE -> ItemModelDescriptionContainer.FENCE_BLOCK_ITEMS.put(registryObject, additionalData);
            case FENCE_GATE -> ItemModelDescriptionContainer.FENCE_GATE_BLOCK_ITEMS.put(registryObject, additionalData);
            case PRESSURE_PLATE -> ItemModelDescriptionContainer.PRESSURE_PLATE_BLOCK_ITEMS.put(registryObject, additionalData);
            case SLAB -> ItemModelDescriptionContainer.SLAB_BLOCK_ITEMS.put(registryObject, additionalData);
            case STAIRS -> ItemModelDescriptionContainer.STAIRS_BLOCK_ITEMS.put(registryObject, additionalData);
            case TRAPDOOR -> ItemModelDescriptionContainer.TRAPDOOR_BLOCK_ITEMS.put(registryObject, additionalData);
            case WALL -> ItemModelDescriptionContainer.WALL_BLOCK_ITEMS.put(registryObject, additionalData);
            case BARREL -> ItemModelDescriptionContainer.BARREL_BLOCK_ITEMS.put(registryObject, additionalData);
            case CARPET -> ItemModelDescriptionContainer.CARPET_BLOCK_ITEMS.put(registryObject, additionalData);
        }
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return GenerateItemModel.class;
    }
}
