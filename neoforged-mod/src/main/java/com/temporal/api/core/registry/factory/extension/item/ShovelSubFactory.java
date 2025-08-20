package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.common.ItemFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.neoforged.neoforge.registries.DeferredItem;

public interface ShovelSubFactory {
    default DeferredItem<ShovelItem> createShovel(String name, Tier tier, float damage, float speed) {
        return this.createShovel(name, new Item.Properties(), tier, damage, speed);
    }

    default DeferredItem<ShovelItem> createShovel(String name, Item.Properties properties, Tier tier, float damage, float speed) {
        ItemFactory itemFactory = InjectionPool.getFromInstance(ItemFactory.class);
        return itemFactory.create(name, properties.attributes(ShovelItem.createAttributes(tier, damage, speed)), props -> new ShovelItem(tier, props));
    }
}
