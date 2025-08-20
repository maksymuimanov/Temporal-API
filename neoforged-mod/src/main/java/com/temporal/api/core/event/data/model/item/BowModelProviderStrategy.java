package com.temporal.api.core.event.data.model.item;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

public class BowModelProviderStrategy implements ItemModelProviderStrategy {
    @Override
    public void registerItemModel(Holder<? extends Item> itemRegistry, ApiItemModelProvider provider, String... additionalData) {
        Item item = itemRegistry.value();
        String itemPath = provider.getItemPath(item);
        provider.simpleItem(itemPath, "bow")
                .override()
                .predicate(provider.mcLoc("pulling"), 1)
                .model(provider.simpleItem(itemPath + "_pulling_0", "bow"))
                .end()
                .override()
                .predicate(provider.mcLoc("pulling"), 1)
                .predicate(provider.mcLoc("pull"), 0.65f)
                .model(provider.simpleItem(itemPath + "_pulling_1", "bow"))
                .end()
                .override()
                .predicate(provider.mcLoc("pulling"), 1)
                .predicate(provider.mcLoc("pull"), 0.9f)
                .model(provider.simpleItem(itemPath + "_pulling_2", "bow"))
                .end();
    }
}
