package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.common.ItemFactory;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public interface ArmorSubFactory {
    default DeferredItem<ArmorItem> createArmor(String name, Holder<ArmorMaterial> material, ArmorItem.Type type) {
        return this.createArmor(name, new Item.Properties(), material, type);
    }

    default DeferredItem<ArmorItem> createArmor(String name, Item.Properties properties, Holder<ArmorMaterial> material, ArmorItem.Type type) {
        ItemFactory itemFactory = InjectionPool.getFromInstance(ItemFactory.class);
        return itemFactory.create(name, properties.stacksTo(1), props -> new ArmorItem(material, type, props));
    }
}
