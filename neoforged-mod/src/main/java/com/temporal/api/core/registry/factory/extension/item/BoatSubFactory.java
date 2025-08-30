package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.ItemFactory;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public interface BoatSubFactory {
    default DeferredItem<BoatItem> createChestBoat(String name, String type) {
        return this.createChestBoat(name, new Item.Properties(), type);
    }

    default DeferredItem<BoatItem> createChestBoat(String name, Item.Properties properties, String type) {
        return this.createBoat(name, properties, type, true);
    }

    default DeferredItem<BoatItem> createBoat(String name, String type) {
        return this.createBoat(name, new Item.Properties(), type);
    }

    default DeferredItem<BoatItem> createBoat(String name, Item.Properties properties, String type) {
        return this.createBoat(name, properties, type, false);
    }

    default DeferredItem<BoatItem> createBoat(String name, Item.Properties properties, String type, boolean hasChest) {
        return this.createBoat(name, properties, Boat.Type.valueOf(type), hasChest);
    }

    default DeferredItem<BoatItem> createBoat(String name, Item.Properties properties, Boat.Type type, boolean hasChest) {
        ItemFactory itemFactory = InjectionPool.getFromInstance(ItemFactory.class);
        return itemFactory.create(name, properties.stacksTo(1), props -> new BoatItem(hasChest, type, props));
    }
}
