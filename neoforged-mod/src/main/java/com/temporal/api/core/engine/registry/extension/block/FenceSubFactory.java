package com.temporal.api.core.engine.registry.extension.block;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.factory.BlockFactory;
import com.temporal.api.core.engine.registry.factory.BlockPropertiesFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

public interface FenceSubFactory {
    default DeferredBlock<FenceBlock> createFence(String name) {
        return this.createFence(name, BlockPropertiesFactory.fence());
    }

    default DeferredBlock<FenceBlock> createFence(String name, BlockBehaviour.Properties properties) {
        return this.createFence(name, properties, new Item.Properties());
    }

    default DeferredBlock<FenceBlock> createFence(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties) {
        final BlockFactory blockFactory = InjectionPool.getFromInstance(BlockFactory.class);
        return blockFactory.create(name, properties, FenceBlock::new, itemProperties);
    }
}
