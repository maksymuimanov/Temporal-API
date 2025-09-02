package com.temporal.api.core.engine.registry.extension.block;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.factory.BlockFactory;
import com.temporal.api.core.engine.registry.factory.BlockPropertiesFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

public interface LeavesSubFactory {
    default DeferredBlock<LeavesBlock> createLeaves(String name) {
        return this.createLeaves(name, BlockPropertiesFactory.leaves());
    }

    default DeferredBlock<LeavesBlock> createLeaves(String name, BlockBehaviour.Properties properties) {
        return this.createLeaves(name, properties, new Item.Properties());
    }

    default DeferredBlock<LeavesBlock> createLeaves(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties) {
        final BlockFactory blockFactory = InjectionPool.getFromInstance(BlockFactory.class);
        return blockFactory.create(name, properties.noOcclusion(), LeavesBlock::new, itemProperties);
    }
}
