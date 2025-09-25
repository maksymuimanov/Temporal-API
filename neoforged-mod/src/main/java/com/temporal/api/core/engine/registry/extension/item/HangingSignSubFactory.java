package com.temporal.api.core.engine.registry.extension.item;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.factory.ItemFactory;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.function.Supplier;

public interface HangingSignSubFactory {
    default DeferredItem<HangingSignItem> createHangingSign(String name, Supplier<CeilingHangingSignBlock> ceilingSignBlock, Supplier<WallHangingSignBlock> wallSignBlock) {
        return this.createHangingSign(name, new Item.Properties(), ceilingSignBlock, wallSignBlock);
    }

    default DeferredItem<HangingSignItem> createHangingSign(String name, Item.Properties properties, Supplier<CeilingHangingSignBlock> ceilingSignBlock, Supplier<WallHangingSignBlock> wallSignBlock) {
        ItemFactory factory = InjectionPool.getFromInstance(ItemFactory.class);
        return factory.create(name, properties, props -> new HangingSignItem(ceilingSignBlock.get(), wallSignBlock.get(), props));
    }
}
