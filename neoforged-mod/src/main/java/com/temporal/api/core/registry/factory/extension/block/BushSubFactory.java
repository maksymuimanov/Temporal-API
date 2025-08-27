package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.BlockFactory;
import com.temporal.api.core.registry.factory.BlockPropertiesFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

public interface BushSubFactory {
    default DeferredBlock<SweetBerryBushBlock> createBush(String name) {
        return this.createBush(name, BlockPropertiesFactory.bush());
    }

    default DeferredBlock<SweetBerryBushBlock> createBush(String name, BlockBehaviour.Properties properties) {
        return this.createBush(name, properties, new Item.Properties());
    }

    default DeferredBlock<SweetBerryBushBlock> createBush(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties) {
        final BlockFactory blockFactory = InjectionPool.getFromInstance(BlockFactory.class);
        return blockFactory.create(name, properties.noOcclusion().noCollission(), SweetBerryBushBlock::new, itemProperties);
    }
}
