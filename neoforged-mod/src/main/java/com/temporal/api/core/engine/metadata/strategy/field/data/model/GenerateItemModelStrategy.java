package com.temporal.api.core.engine.metadata.strategy.field.data.model;

import com.temporal.api.core.engine.event.data.model.item.ItemModelDescriptionContainer;
import com.temporal.api.core.engine.event.data.model.item.ItemModelProviderStrategy;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.model.GenerateItemModel;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateItemModelStrategy implements FieldAnnotationStrategy<GenerateItemModel> {
    @Override
    public void execute(Field field, Object object, GenerateItemModel annotation) throws Exception {
        Holder<? extends Item> registryObject = ReflectionUtils.getItemHolder(field, object);
        String[] additionalData = annotation.additionalData();
        if (!ItemModelProviderStrategy.class.equals(annotation.custom())) {
            ItemModelProviderStrategy providerStrategy = annotation.custom()
                    .getDeclaredConstructor()
                    .newInstance();
            ItemModelDescriptionContainer.CUSTOM_MODELS.put(new Tuple<>(registryObject, additionalData), providerStrategy);
            return;
        }
        switch (annotation.value()) {
            case BASIC -> ItemModelDescriptionContainer.BASIC_ITEMS.put(registryObject, additionalData);
            case HANDHELD -> ItemModelDescriptionContainer.HANDHELD_ITEMS.put(registryObject, additionalData);
            case BOW -> ItemModelDescriptionContainer.BOW_ITEMS.put(registryObject, additionalData);
            case CROSSBOW -> ItemModelDescriptionContainer.CROSSBOW_ITEMS.put(registryObject, additionalData);
            case TRIMMED_ARMOR -> ItemModelDescriptionContainer.TRIMMED_ARMOR_ITEMS.put(registryObject, additionalData);
            case POTION -> ItemModelDescriptionContainer.POTION_ITEMS.put(registryObject, additionalData);
            case SPAWN_EGG -> ItemModelDescriptionContainer.SPAWN_EGG_ITEMS.put(registryObject, additionalData);
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
    public Class<? extends GenerateItemModel> getAnnotationClass() {
        return GenerateItemModel.class;
    }
}
