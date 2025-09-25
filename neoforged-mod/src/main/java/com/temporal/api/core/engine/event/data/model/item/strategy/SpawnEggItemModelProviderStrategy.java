package com.temporal.api.core.engine.event.data.model.item.strategy;

import com.temporal.api.core.engine.event.data.model.item.ApiItemModelProvider;
import com.temporal.api.core.engine.event.data.model.item.ItemModelProviderStrategy;
import com.temporal.api.core.engine.event.data.model.item.spec.ItemModelSpec;
import net.minecraft.resources.ResourceLocation;

public class SpawnEggItemModelProviderStrategy implements ItemModelProviderStrategy<ItemModelSpec> {
    @Override
    public void registerItemModel(ItemModelSpec spec, ApiItemModelProvider provider) {
        ResourceLocation texture = spec.getLocation();
        provider.spawnEggItem(texture);
    }
}
