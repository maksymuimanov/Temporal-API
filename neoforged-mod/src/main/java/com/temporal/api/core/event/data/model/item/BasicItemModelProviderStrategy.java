package com.temporal.api.core.event.data.model.item;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

public class BasicItemModelProviderStrategy implements ItemModelProviderStrategy {
    @Override
    public void registerItemModel(Holder<? extends Item> itemRegistry, ApiItemModelProvider provider, String... additionalData) {
        Item item = itemRegistry.value();
        provider.basicItem(item);
    }
}
