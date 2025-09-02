package com.temporal.api.core.engine.registry.extension.item;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.factory.ItemFactory;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public interface CrossbowSubFactory {
    default DeferredItem<CrossbowItem> createCrossbow(String name) {
        return this.createCrossbow(name, new Item.Properties());
    }

    default DeferredItem<CrossbowItem> createCrossbow(String name, Item.Properties properties) {
        ItemFactory itemFactory = InjectionPool.getFromInstance(ItemFactory.class);
        return itemFactory.create(name, properties.stacksTo(1), CrossbowItem::new);
    }
}
