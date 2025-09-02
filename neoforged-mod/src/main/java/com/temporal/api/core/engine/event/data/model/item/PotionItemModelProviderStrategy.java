package com.temporal.api.core.engine.event.data.model.item;

import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

public class PotionItemModelProviderStrategy implements ItemModelProviderStrategy {
    @Override
    public void registerItemModel(Holder<? extends Item> itemRegistry, ApiItemModelProvider provider, String... additionalData) {
        Item item = itemRegistry.value();
        String itemPath = provider.getItemPath(item);
        provider.withExistingParent(itemPath, "item/potion")
                .texture(ApiItemModelProvider.LAYER_0, provider.mcLoc("item/potion_overlay"))
                .texture(ApiItemModelProvider.LAYER_1, ResourceUtils.parse(itemPath));
    }
}
