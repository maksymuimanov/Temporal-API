package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.common.block.LogBlock;
import com.temporal.api.common.block.StrippableLogBlock;
import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.common.BlockFactory;
import com.temporal.api.core.registry.factory.other.BlockPropertiesFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Supplier;

public interface LogSubFactory {
    default DeferredBlock<StrippableLogBlock> createLog(String name, Supplier<? extends Block> strippedBlock) {
        return createLog(name, BlockPropertiesFactory.wood(), strippedBlock);
    }

    default DeferredBlock<StrippableLogBlock> createLog(String name, BlockBehaviour.Properties properties, Supplier<? extends Block> strippedBlock) {
        return createLog(name, properties, new Item.Properties(), strippedBlock);
    }

    default DeferredBlock<StrippableLogBlock> createLog(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties, Supplier<? extends Block> strippedBlock) {
        final BlockFactory blockFactory = InjectionPool.getFromInstance(BlockFactory.class);
        return blockFactory.create(name, properties, props -> new StrippableLogBlock(strippedBlock.get(), props), itemProperties);
    }

    default DeferredBlock<LogBlock> createLog(String name) {
        return createLog(name, BlockPropertiesFactory.wood());
    }

    default DeferredBlock<LogBlock> createLog(String name, BlockBehaviour.Properties properties) {
        return createLog(name, properties, new Item.Properties());
    }

    default DeferredBlock<LogBlock> createLog(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties) {
        final BlockFactory blockFactory = InjectionPool.getFromInstance(BlockFactory.class);
        return blockFactory.create(name, properties, LogBlock::new, itemProperties);
    }
}
