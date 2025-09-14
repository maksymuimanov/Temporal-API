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

    public ItemFactory(final TemporalRegister<Item> items) {
        super(items);
    }

    public DeferredItem<Item> create(final String name) {
        return create(name, new Item.Properties());
    }

    public DeferredItem<Item> create(final String name, final Item.Properties properties) {
        return create(name, properties, Item::new);
    }

    public <T extends Item> DeferredItem<T> create(final String name, final Item.Properties properties, final Function<Item.Properties, T> function) {
        return (DeferredItem<T>) create(name, () -> function.apply(properties));
    }
}
