package com.temporal.api.core.engine.registry.extension.block;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.factory.BlockFactory;
import com.temporal.api.core.engine.registry.factory.BlockPropertiesFactory;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Supplier;

public interface FlowerSubFactory {
    default DeferredBlock<FlowerBlock> createFlower(String name, Holder<MobEffect> mobEffect, int duration) {
        return this.createFlower(name, BlockPropertiesFactory.flower(), mobEffect, duration);
    }

    default DeferredBlock<FlowerBlock> createFlower(String name, BlockBehaviour.Properties properties, Holder<MobEffect> mobEffect, int duration) {
        return this.createFlower(name, properties, new Item.Properties(), mobEffect, duration);
    }

    default DeferredBlock<FlowerBlock> createFlower(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties, Holder<MobEffect> mobEffect, int duration) {
        final BlockFactory blockFactory = InjectionPool.getFromInstance(BlockFactory.class);
        return blockFactory.create(name, properties.noOcclusion().noCollission(), props -> new FlowerBlock(mobEffect, duration, props), itemProperties);
    }

    default DeferredBlock<FlowerPotBlock> createPottedFlower(String name, Supplier<? extends Block> flower) {
        return this.createPottedFlower(name, BlockPropertiesFactory.flowerPot(), flower);
    }

    @SuppressWarnings("deprecation")
    default DeferredBlock<FlowerPotBlock> createPottedFlower(String name, BlockBehaviour.Properties properties, Supplier<? extends Block> flower) {
        final BlockFactory blockFactory = InjectionPool.getFromInstance(BlockFactory.class);
        return blockFactory.createWithoutItem(name, properties, props -> new FlowerPotBlock(flower.get(), props));
    }
}
