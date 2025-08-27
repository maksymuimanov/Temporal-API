package com.temporal.api.core.registry.factory;

import com.temporal.api.core.engine.io.context.InjectionPool;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ItemFactory extends AbstractObjectFactory<Item> {
    public ItemFactory() {
        this(InjectionPool.getFromInstance("$Items"));
    }

    public ItemFactory(DeferredRegister.Items items) {
        super(items);
    }

    public DeferredItem<Item> create(String name) {
        return this.create(name, new Item.Properties());
    }

    public DeferredItem<Item> create(String name, Item.Properties properties) {
        return this.create(name, properties, Item::new);
    }

    public <T extends Item> DeferredItem<T> create(String name, Item.Properties properties, Function<Item.Properties, T> function) {
        return ((DeferredRegister.Items) this.getRegistry()).registerItem(name, function, properties);
    }
}
