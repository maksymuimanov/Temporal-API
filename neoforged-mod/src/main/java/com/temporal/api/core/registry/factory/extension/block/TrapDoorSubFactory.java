package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.BlockFactory;
import com.temporal.api.core.registry.factory.BlockPropertiesFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.neoforge.registries.DeferredBlock;

public interface TrapDoorSubFactory {
    default DeferredBlock<TrapDoorBlock> createTrapDoor(String name) {
        return this.createTrapDoor(name, BlockPropertiesFactory.trapDoor());
    }

    default DeferredBlock<TrapDoorBlock> createTrapDoor(String name, BlockBehaviour.Properties properties) {
        return this.createTrapDoor(name, properties, BlockSetType.OAK);
    }

    default DeferredBlock<TrapDoorBlock> createTrapDoor(String name, BlockBehaviour.Properties properties, BlockSetType setType) {
        return this.createTrapDoor(name, properties, new Item.Properties(), setType);
    }

    default DeferredBlock<TrapDoorBlock> createTrapDoor(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties) {
        return this.createTrapDoor(name, properties, itemProperties, BlockSetType.OAK);
    }

    default DeferredBlock<TrapDoorBlock> createTrapDoor(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties, BlockSetType setType) {
        final BlockFactory blockFactory = InjectionPool.getFromInstance(BlockFactory.class);
        return blockFactory.create(name, properties, props -> new TrapDoorBlock(setType, props), itemProperties);
    }
}
