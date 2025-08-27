package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.ItemFactory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.function.Supplier;

public interface SpawnEggSubFactory {
    default DeferredItem<SpawnEggItem> createSpawnEgg(String name, Supplier<? extends EntityType<? extends Mob>> type, int backgroundColor, int highlightColor) {
        return this.createSpawnEgg(name, new Item.Properties(), type, backgroundColor, highlightColor);
    }

    @SuppressWarnings("deprecation")
    default DeferredItem<SpawnEggItem> createSpawnEgg(String name, Item.Properties properties, Supplier<? extends EntityType<? extends Mob>> type, int backgroundColor, int highlightColor) {
        ItemFactory itemFactory = InjectionPool.getFromInstance(ItemFactory.class);
        return itemFactory.create(name, properties, props -> new SpawnEggItem(type.get(), backgroundColor, highlightColor, props));
    }
}
