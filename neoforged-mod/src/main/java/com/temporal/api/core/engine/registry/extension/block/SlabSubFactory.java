package com.temporal.api.core.engine.registry.extension.block;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.factory.BlockFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

public interface SlabSubFactory {
    default DeferredBlock<SlabBlock> createSlab(String name, BlockBehaviour.Properties properties) {
        return this.createSlab(name, properties, new Item.Properties());
    }

    default DeferredBlock<SlabBlock> createSlab(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties) {
        final BlockFactory blockFactory = InjectionPool.getFromInstance(BlockFactory.class);
        return blockFactory.create(name, properties, SlabBlock::new, itemProperties);
    }
}
