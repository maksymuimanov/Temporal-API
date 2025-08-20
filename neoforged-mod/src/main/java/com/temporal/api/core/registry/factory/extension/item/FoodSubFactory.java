package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.common.ItemFactory;
import com.temporal.api.core.registry.factory.other.FoodPropertiesFactory;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public interface FoodSubFactory {
    default DeferredItem<Item> createFood(String name, int nutrition, float saturation) {
        return createFood(name, new Item.Properties(), nutrition, saturation);
    }

    default DeferredItem<Item> createFood(String name, Item.Properties properties, int nutrition, float saturation) {
        return createFood(name, properties, FoodPropertiesFactory.simple(nutrition, saturation).build());
    }

    default DeferredItem<Item> createFood(String name, Item.Properties properties, FoodProperties foodProperties) {
        ItemFactory itemFactory = InjectionPool.getFromInstance(ItemFactory.class);
        return itemFactory.create(name, properties.food(foodProperties), Item::new);
    }
}
