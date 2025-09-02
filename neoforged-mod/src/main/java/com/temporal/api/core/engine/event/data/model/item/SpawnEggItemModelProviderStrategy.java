package com.temporal.api.core.engine.event.data.model.item;

import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

public class SpawnEggItemModelProviderStrategy implements ItemModelProviderStrategy {
    @Override
    public void registerItemModel(Holder<? extends Item> itemRegistry, ApiItemModelProvider provider, String... additionalData) {
        Item item = itemRegistry.value();
        String itemPath = provider.getItemPath(item);
        provider.spawnEggItem(ResourceUtils.parse(itemPath));
    }
}
