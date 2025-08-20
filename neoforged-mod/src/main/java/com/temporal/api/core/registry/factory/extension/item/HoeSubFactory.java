package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.common.ItemFactory;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.neoforged.neoforge.registries.DeferredItem;

public interface HoeSubFactory {
    default DeferredItem<HoeItem> createHoe(String name, Tier tier, int damage, float speed) {
        return this.createHoe(name, new Item.Properties(), tier, damage, speed);
    }

    default DeferredItem<HoeItem> createHoe(String name, Item.Properties properties, Tier tier, int damage, float speed) {
        ItemFactory itemFactory = InjectionPool.getFromInstance(ItemFactory.class);
        return itemFactory.create(name, properties.attributes(HoeItem.createAttributes(tier, damage, speed)), props -> new HoeItem(tier, props));
    }
}
