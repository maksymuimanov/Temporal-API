package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.function.Function;

public class ItemFactory extends AbstractObjectFactory<Item> {
    public ItemFactory() {
        this(InjectionPool.getFromInstance("$Items"));
    }

    public ItemFactory(TemporalRegister<Item> register) {
        super(register);
    }

    public DeferredItem<Item> create(String name) {
        return this.create(name, new Item.Properties());
    }

    public DeferredItem<Item> create(String name, Item.Properties properties) {
        return this.create(name, properties, Item::new);
    }

    public <T extends Item> DeferredItem<T> create(String name, Item.Properties properties, Function<Item.Properties, T> function) {
        return (DeferredItem<T>) this.create(name, () -> function.apply(properties));
    }
}
