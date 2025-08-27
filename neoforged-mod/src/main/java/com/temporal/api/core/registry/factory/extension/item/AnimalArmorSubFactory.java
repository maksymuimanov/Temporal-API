package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.ItemFactory;
import net.minecraft.core.Holder;
import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public interface AnimalArmorSubFactory {
    default DeferredItem<AnimalArmorItem> createAnimalArmor(String name, Holder<ArmorMaterial> material, AnimalArmorItem.BodyType type, boolean hasOverlay) {
        return this.createAnimalArmor(name, new Item.Properties(), material, type, hasOverlay);
    }

    default DeferredItem<AnimalArmorItem> createAnimalArmor(String name, Item.Properties properties, Holder<ArmorMaterial> material, AnimalArmorItem.BodyType type, boolean hasOverlay) {
        ItemFactory itemFactory = InjectionPool.getFromInstance(ItemFactory.class);
        return itemFactory.create(name, properties, props -> new AnimalArmorItem(material, type, hasOverlay, props));
    }
}
