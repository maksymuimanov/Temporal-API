package com.temporal.api.core.engine.event.data.model.item;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

public class HandheldItemModelProviderStrategy implements ItemModelProviderStrategy {
    @Override
    public void registerItemModel(Holder<? extends Item> itemRegistry, ApiItemModelProvider provider, String... additionalData) {
        Item item = itemRegistry.value();
        provider.handheldItem(item);
    }
}
