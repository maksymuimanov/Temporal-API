package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.BlockFactory;
import com.temporal.api.core.registry.factory.BlockPropertiesFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.neoforge.registries.DeferredBlock;

public interface DoorSubFactory {
    default DeferredBlock<DoorBlock> createDoor(String name) {
        return createDoor(name, BlockPropertiesFactory.door());
    }

    default DeferredBlock<DoorBlock> createDoor(String name, BlockBehaviour.Properties properties) {
        return this.createDoor(name, properties, BlockSetType.OAK);
    }

    default DeferredBlock<DoorBlock> createDoor(String name, BlockBehaviour.Properties properties, BlockSetType setType) {
        return this.createDoor(name, properties, new Item.Properties(), setType);
    }

    default DeferredBlock<DoorBlock> createDoor(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties) {
        return this.createDoor(name, properties, itemProperties, BlockSetType.OAK);
    }
    
    default DeferredBlock<DoorBlock> createDoor(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties, BlockSetType setType) {
        final BlockFactory blockFactory = InjectionPool.getFromInstance(BlockFactory.class);
        return blockFactory.create(name, properties, props -> new DoorBlock(setType, props), itemProperties);
    }
}
