package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.common.BlockFactory;
import com.temporal.api.core.registry.factory.other.BlockPropertiesFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.neoforge.registries.DeferredBlock;

public interface TrapDoorSubFactory {
    default DeferredBlock<TrapDoorBlock> createTrapDoor(String name) {
        return createTrapDoor(name, BlockPropertiesFactory.trapDoor());
    }

    default DeferredBlock<TrapDoorBlock> createTrapDoor(String name, BlockBehaviour.Properties properties) {
        return createTrapDoor(name, properties, BlockSetType.OAK);
    }

    default DeferredBlock<TrapDoorBlock> createTrapDoor(String name, BlockBehaviour.Properties properties, BlockSetType setType) {
        return createTrapDoor(name, properties, new Item.Properties(), setType);
    }

    default DeferredBlock<TrapDoorBlock> createTrapDoor(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties) {
        return createTrapDoor(name, properties, itemProperties, BlockSetType.OAK);
    }

    default DeferredBlock<TrapDoorBlock> createTrapDoor(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties, BlockSetType setType) {
        final BlockFactory blockFactory = InjectionPool.getFromInstance(BlockFactory.class);
        return blockFactory.create(name, properties, props -> new TrapDoorBlock(setType, props), itemProperties);
    }
}
