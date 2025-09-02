package com.temporal.api.core.engine.event.data.model.item;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

public class CrossbowModelProviderStrategy implements ItemModelProviderStrategy {
    @Override
    public void registerItemModel(Holder<? extends Item> itemRegistry, ApiItemModelProvider provider, String... additionalData) {
        Item item = itemRegistry.value();
        String itemPath = provider.getItemPath(item);
        provider.simpleItem(itemPath, "crossbow")
                .override()
                .predicate(provider.mcLoc("pulling"), 1)
                .model(provider.simpleItem(itemPath + "_pulling_0", "crossbow"))
                .end()
                .override()
                .predicate(provider.mcLoc("pulling"), 1)
                .predicate(provider.mcLoc("pull"), 0.58f)
                .model(provider.simpleItem(itemPath + "_pulling_1", "crossbow"))
                .end()
                .override()
                .predicate(provider.mcLoc("pulling"), 1)
                .predicate(provider.mcLoc("pull"), 1f)
                .model(provider.simpleItem(itemPath + "_pulling_2", "crossbow"))
                .end()
                .override()
                .predicate(provider.mcLoc("charged"), 1)
                .model(provider.simpleItem(itemPath + "_arrow", "crossbow"))
                .end()
                .override()
                .predicate(provider.mcLoc("charged"), 1)
                .predicate(provider.mcLoc("firework"), 1)
                .model(provider.simpleItem(itemPath + "_firework", "crossbow"))
                .end();
    }
}
