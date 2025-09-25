package com.temporal.api.core.engine.registry.extension.item;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.factory.ItemFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.neoforged.neoforge.registries.DeferredItem;

public interface PickaxeSubFactory {
    default DeferredItem<PickaxeItem> createPickaxe(String name, Tier tier, int damage, float speed) {
        return this.createPickaxe(name, new Item.Properties(), tier, damage, speed);
    }

    default DeferredItem<PickaxeItem> createPickaxe(String name, Item.Properties properties, Tier tier, int damage, float speed) {
        ItemFactory itemFactory = InjectionPool.getFromInstance(ItemFactory.class);
        return itemFactory.create(name, properties.attributes(PickaxeItem.createAttributes(tier, damage, speed)), props -> new PickaxeItem(tier, props));
    }
}
