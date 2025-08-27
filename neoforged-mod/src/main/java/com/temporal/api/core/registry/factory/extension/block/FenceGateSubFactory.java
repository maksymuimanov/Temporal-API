package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.BlockFactory;
import com.temporal.api.core.registry.factory.BlockPropertiesFactory;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.Optional;

public interface FenceGateSubFactory {
    default DeferredBlock<FenceGateBlock> createFenceGate(String name, WoodType woodType) {
        return this.createFenceGate(name, woodType, BlockPropertiesFactory.fenceGate());
    }

    default DeferredBlock<FenceGateBlock> createFenceGate(String name, WoodType woodType, BlockBehaviour.Properties properties) {
        return this.createFenceGate(name, properties, woodType, SoundEvents.WOODEN_DOOR_OPEN, SoundEvents.WOODEN_DOOR_CLOSE);
    }

    default DeferredBlock<FenceGateBlock> createFenceGate(String name, BlockBehaviour.Properties properties, WoodType woodType, SoundEvent openSound, SoundEvent closeSound) {
        return this.createFenceGate(name, properties, new Item.Properties(), woodType, openSound, closeSound);
    }

    default DeferredBlock<FenceGateBlock> createFenceGate(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties, WoodType woodType, SoundEvent openSound, SoundEvent closeSound) {
        final BlockFactory blockFactory = InjectionPool.getFromInstance(BlockFactory.class);
        return blockFactory.create(name, properties, (props) -> new FenceGateBlock(Optional.of(woodType), props, Optional.of(openSound), Optional.of(closeSound)), itemProperties);
    }
}
