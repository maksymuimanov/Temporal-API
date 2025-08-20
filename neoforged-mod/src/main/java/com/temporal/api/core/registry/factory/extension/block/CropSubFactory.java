package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.common.block.ApiCropBlock;
import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.common.BlockFactory;
import com.temporal.api.core.registry.factory.other.BlockPropertiesFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

public interface CropSubFactory {
    default DeferredBlock<ApiCropBlock> createCrop(String name) {
        return createCrop(name, BlockPropertiesFactory.crop());
    }

    default DeferredBlock<ApiCropBlock> createCrop(String name, BlockBehaviour.Properties properties) {
        return createCrop(name, properties, new Item.Properties());
    }

    default DeferredBlock<ApiCropBlock> createCrop(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties) {
        final BlockFactory blockFactory = InjectionPool.getFromInstance(BlockFactory.class);
        return blockFactory.create(name, properties.noOcclusion().noCollission(), ApiCropBlock::new, itemProperties);
    }
}
