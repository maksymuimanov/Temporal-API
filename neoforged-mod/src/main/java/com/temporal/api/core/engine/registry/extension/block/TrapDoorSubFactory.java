package com.temporal.api.core.engine.registry.extension.block;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.factory.BlockFactory;
import com.temporal.api.core.engine.registry.factory.BlockPropertiesFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.neoforge.registries.DeferredBlock;

public interface TrapDoorSubFactory {
    default DeferredBlock<TrapDoorBlock> createTrapDoor(String name, BlockSetType setType) {
        return this.createTrapDoor(name, BlockPropertiesFactory.trapDoor(), setType);
    }

    default DeferredBlock<TrapDoorBlock> createTrapDoor(String name, BlockBehaviour.Properties properties, BlockSetType setType) {
        return this.createTrapDoor(name, properties, new Item.Properties(), setType);
    }

    default DeferredBlock<TrapDoorBlock> createTrapDoor(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties, BlockSetType setType) {
        final BlockFactory blockFactory = InjectionPool.getFromInstance(BlockFactory.class);
        return blockFactory.create(name, properties, props -> new TrapDoorBlock(setType, props), itemProperties);
    }
}
