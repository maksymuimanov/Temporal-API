package com.temporal.api.core.registry.factory.common;

import com.temporal.api.core.engine.io.context.InjectionPool;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

@SuppressWarnings("unchecked")
public class ItemFactory extends AbstractObjectFactory<Item> {
    private final DeferredRegister.Items items;

    public ItemFactory() {
        this(InjectionPool.getFromInstance("$Items"));
    }

    public ItemFactory(DeferredRegister.Items items) {
        this.items = items;
    }

    public <T extends Item> DeferredItem<T> create(String name) {
        return (DeferredItem<T>) items.registerSimpleItem(name);
    }

    public <T extends Item> DeferredItem<T> create(String name, Item.Properties properties) {
        return (DeferredItem<T>) items.registerSimpleItem(name, properties);
    }

    public <T extends Item> DeferredItem<T> create(String name, Item.Properties properties, Function<Item.Properties, T> function) {
        return items.registerItem(name, function, properties);
    }

    @Override
    public DeferredRegister<Item> getRegistry() {
        return items;
    }
}
