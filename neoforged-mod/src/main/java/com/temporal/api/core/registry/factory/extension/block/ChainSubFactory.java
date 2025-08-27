package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.BlockFactory;
import com.temporal.api.core.registry.factory.BlockPropertiesFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

public interface ChainSubFactory {
    default DeferredBlock<ChainBlock> createChain(String name) {
        return this.createChain(name, BlockPropertiesFactory.chain());
    }

    default DeferredBlock<ChainBlock> createChain(String name, BlockBehaviour.Properties properties) {
        return this.createChain(name, properties, new Item.Properties());
    }

    default DeferredBlock<ChainBlock> createChain(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties) {
        final BlockFactory blockFactory = InjectionPool.getFromInstance(BlockFactory.class);
        return blockFactory.create(name, properties.sound(SoundType.CHAIN).noOcclusion(), ChainBlock::new, itemProperties);
    }
}
