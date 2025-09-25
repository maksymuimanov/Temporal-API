package com.temporal.api.core.engine.registry.extension.block;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.factory.BlockFactory;
import com.temporal.api.core.engine.registry.factory.BlockPropertiesFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.neoforge.registries.DeferredBlock;

public interface PressurePlateSubFactory {
    default DeferredBlock<PressurePlateBlock> createPressurePlate(String name, BlockSetType setType) {
        return this.createPressurePlate(name, BlockPropertiesFactory.pressurePlate(), setType);
    }

    default DeferredBlock<PressurePlateBlock> createPressurePlate(String name, BlockBehaviour.Properties properties, BlockSetType setType) {
        return this.createPressurePlate(name, properties, new Item.Properties(), setType);
    }

    default DeferredBlock<PressurePlateBlock> createPressurePlate(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties, BlockSetType setType) {
        final BlockFactory blockFactory = InjectionPool.getFromInstance(BlockFactory.class);
        return blockFactory.create(name, properties, props -> new PressurePlateBlock(setType, props), itemProperties);
    }
}
