package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.BlockFactory;
import com.temporal.api.core.registry.factory.BlockPropertiesFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

public interface WallSubFactory {
    default DeferredBlock<WallBlock> createWall(String name) {
        return this.createWall(name, BlockPropertiesFactory.wall());
    }

    default DeferredBlock<WallBlock> createWall(String name, BlockBehaviour.Properties properties) {
        return this.createWall(name, properties, new Item.Properties());
    }

    default DeferredBlock<WallBlock> createWall(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties) {
        final BlockFactory blockFactory = InjectionPool.getFromInstance(BlockFactory.class);
        return blockFactory.create(name, properties, WallBlock::new, itemProperties);
    }
}
