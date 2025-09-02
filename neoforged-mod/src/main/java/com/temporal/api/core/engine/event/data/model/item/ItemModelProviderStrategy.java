package com.temporal.api.core.engine.event.data.model.item;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

public interface ItemModelProviderStrategy {
    void registerItemModel(Holder<? extends Item> itemRegistry, ApiItemModelProvider provider, String... additionalData);
}
