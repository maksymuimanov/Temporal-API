package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.BlockFactory;
import com.temporal.api.core.registry.factory.BlockPropertiesFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.neoforge.registries.DeferredBlock;

public interface PressurePlateSubFactory {
    default DeferredBlock<PressurePlateBlock> createPressurePlate(String name) {
        return this.createPressurePlate(name, BlockPropertiesFactory.pressurePlate());
    }

    default DeferredBlock<PressurePlateBlock> createPressurePlate(String name, BlockBehaviour.Properties properties) {
        return this.createPressurePlate(name, properties, BlockSetType.OAK);
    }

    default DeferredBlock<PressurePlateBlock> createPressurePlate(String name, BlockBehaviour.Properties properties, BlockSetType setType) {
        return this.createPressurePlate(name, properties, new Item.Properties(), setType);
    }

    default DeferredBlock<PressurePlateBlock> createPressurePlate(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties) {
        return this.createPressurePlate(name, properties, itemProperties, BlockSetType.OAK);
    }

    default DeferredBlock<PressurePlateBlock> createPressurePlate(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties, BlockSetType setType) {
        final BlockFactory blockFactory = InjectionPool.getFromInstance(BlockFactory.class);
        return blockFactory.create(name, properties, props -> new PressurePlateBlock(setType, props), itemProperties);
    }
}
