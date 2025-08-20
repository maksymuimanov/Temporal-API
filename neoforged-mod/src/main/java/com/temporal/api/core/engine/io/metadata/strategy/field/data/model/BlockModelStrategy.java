package com.temporal.api.core.engine.io.metadata.strategy.field.data.model;

import com.temporal.api.core.collection.SimplePair;
import com.temporal.api.core.engine.io.metadata.annotation.data.model.BlockModel;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.model.block.BlockModelDescriptionContainer;
import com.temporal.api.core.event.data.model.block.BlockModelProviderStrategy;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class BlockModelStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Holder<? extends Block> registryObject = (Holder<? extends Block>) field.get(object);
        BlockModel blockModel = field.getDeclaredAnnotation(BlockModel.class);
        String[] additionalData = blockModel.additionalData();
        if (!BlockModelProviderStrategy.class.equals(blockModel.custom())) {
            BlockModelProviderStrategy providerStrategy = blockModel.custom()
                    .getDeclaredConstructor()
                    .newInstance();
            BlockModelDescriptionContainer.CUSTOM_MODELS.put(new SimplePair<>(registryObject, additionalData), providerStrategy);
            return;
        }
        switch (blockModel.value()) {
            case CUBED -> BlockModelDescriptionContainer.CUBED_BLOCKS.put(registryObject, additionalData);
            case CUTOUT_CUBED -> BlockModelDescriptionContainer.CUTOUT_CUBED_BLOCKS.put(registryObject, additionalData);
            case CROSS -> BlockModelDescriptionContainer.CROSS_BLOCKS.put(registryObject, additionalData);
            case FLOWER -> BlockModelDescriptionContainer.FLOWER_BLOCKS.put(registryObject, additionalData);
            case LOG -> BlockModelDescriptionContainer.LOGS.put(registryObject, additionalData);
            case WOOD -> BlockModelDescriptionContainer.WOODS.put(registryObject, additionalData);
            case DOOR -> BlockModelDescriptionContainer.DOORS.put(registryObject, additionalData);
            case BUTTON -> BlockModelDescriptionContainer.BUTTONS.put(registryObject, additionalData);
            case FENCE -> BlockModelDescriptionContainer.FENCES.put(registryObject, additionalData);
            case FENCE_GATE -> BlockModelDescriptionContainer.FENCE_GATES.put(registryObject, additionalData);
            case PRESSURE_PLATE -> BlockModelDescriptionContainer.PRESSURE_PLATES.put(registryObject, additionalData);
            case TRAPDOOR -> BlockModelDescriptionContainer.TRAPDOORS.put(registryObject, additionalData);
            case SLAB -> BlockModelDescriptionContainer.SLABS.put(registryObject, additionalData);
            case STAIRS -> BlockModelDescriptionContainer.STAIRS.put(registryObject, additionalData);
            case WALL -> BlockModelDescriptionContainer.WALLS.put(registryObject, additionalData);
            case SIGN -> BlockModelDescriptionContainer.SIGNS.put(registryObject, additionalData);
            case HANGING_SIGN -> BlockModelDescriptionContainer.HANGING_SIGNS.put(registryObject, additionalData);
            case BARREL -> BlockModelDescriptionContainer.BARRELS.put(registryObject, additionalData);
            case VINE -> BlockModelDescriptionContainer.VINES.put(registryObject, additionalData);
            case CARPET -> BlockModelDescriptionContainer.CARPETS.put(registryObject, additionalData);
            case PANE -> BlockModelDescriptionContainer.PANES.put(registryObject, additionalData);
            case RAIL -> BlockModelDescriptionContainer.RAILS.put(registryObject, additionalData);
        }
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return BlockModel.class;
    }
}
