package com.temporal.api.core.engine.registry.extension.item;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.factory.ItemFactory;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.neoforged.neoforge.registries.DeferredItem;

public interface AxeSubFactory {
    default DeferredItem<AxeItem> createAxe(String name, Tier tier, float damage, float speed) {
        return this.createAxe(name, new Item.Properties(), tier, damage, speed);
    }

    default DeferredItem<AxeItem> createAxe(String name, Item.Properties properties, Tier tier, float damage, float speed) {
        ItemFactory itemFactory = InjectionPool.getFromInstance(ItemFactory.class);
        return itemFactory.create(name, properties.attributes(AxeItem.createAttributes(tier, damage, speed)), props -> new AxeItem(tier, props));
    }
}
