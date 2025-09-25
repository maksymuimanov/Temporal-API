package com.temporal.api.core.engine.event.data.model.item.strategy;

import com.temporal.api.core.engine.event.data.model.item.ApiItemModelProvider;
import com.temporal.api.core.engine.event.data.model.item.ItemModelProviderStrategy;
import com.temporal.api.core.engine.event.data.model.item.spec.ItemModelSpec;
import net.minecraft.world.item.Item;

public class BasicItemModelProviderStrategy implements ItemModelProviderStrategy<ItemModelSpec> {
    @Override
    public void registerItemModel(ItemModelSpec spec, ApiItemModelProvider provider) {
        Item item = spec.getItem();
        provider.basicItem(item);
    }
}
