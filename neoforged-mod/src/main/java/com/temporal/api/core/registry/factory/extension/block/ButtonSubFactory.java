package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.common.BlockFactory;
import com.temporal.api.core.registry.factory.other.BlockPropertiesFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.neoforge.registries.DeferredBlock;

public interface ButtonSubFactory {
    default DeferredBlock<ButtonBlock> createButton(String name) {
        return createButton(name, BlockPropertiesFactory.button());
    }

    default DeferredBlock<ButtonBlock> createButton(String name, BlockBehaviour.Properties properties) {
        return createButton(name, properties, BlockSetType.OAK, 30);
    }

    default DeferredBlock<ButtonBlock> createButton(String name, BlockBehaviour.Properties properties, BlockSetType setType, int ticksToStayPressed) {
        return createButton(name, properties, new Item.Properties(), setType, ticksToStayPressed);
    }

    default DeferredBlock<ButtonBlock> createButton(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties) {
        return createButton(name, properties, itemProperties, BlockSetType.OAK, 30);
    }

    default DeferredBlock<ButtonBlock> createButton(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties, BlockSetType setType, int ticksToStayPressed) {
        final BlockFactory blockFactory = InjectionPool.getFromInstance(BlockFactory.class);
        return blockFactory.create(name,  properties, props -> new ButtonBlock(setType, ticksToStayPressed, props), itemProperties);
    }
}
