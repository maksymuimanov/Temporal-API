package com.temporal.api.core.engine.registry.extension.item;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.factory.ItemFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.function.Supplier;

public interface SignSubFactory {
    default DeferredItem<SignItem> createSign(String name, Supplier<StandingSignBlock> standingSignBlock, Supplier<WallSignBlock> wallSignBlock) {
        return this.createSign(name, new Item.Properties(), standingSignBlock, wallSignBlock);
    }

    default DeferredItem<SignItem> createSign(String name, Item.Properties properties, Supplier<StandingSignBlock> standingSignBlock, Supplier<WallSignBlock> wallSignBlock) {
        ItemFactory factory = InjectionPool.getFromInstance(ItemFactory.class);
        return factory.create(name, properties, props -> new SignItem(props, standingSignBlock.get(), wallSignBlock.get()));
    }
}
