package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.BlockFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

public interface StairSubFactory {
    default DeferredBlock<StairBlock> createStair(String name, BlockBehaviour.Properties properties) {
        return this.createStair(name, properties, new Item.Properties(), Blocks.OAK_PLANKS);
    }

    default DeferredBlock<StairBlock> createStair(String name, BlockBehaviour.Properties properties, Block block) {
        return this.createStair(name, properties, new Item.Properties(), block);
    }

    default DeferredBlock<StairBlock> createStair(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties, Block block) {
        final BlockFactory blockFactory = InjectionPool.getFromInstance(BlockFactory.class);
        return blockFactory.create(name, properties, props -> new StairBlock(block.defaultBlockState(), props), itemProperties);
    }
}
