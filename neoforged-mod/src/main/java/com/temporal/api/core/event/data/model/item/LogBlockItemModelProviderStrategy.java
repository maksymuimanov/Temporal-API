package com.temporal.api.core.event.data.model.item;

import com.temporal.api.core.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

public class LogBlockItemModelProviderStrategy implements ItemModelProviderStrategy {
    @Override
    public void registerItemModel(Holder<? extends Item> itemRegistry, ApiItemModelProvider provider, String... additionalData) {
        Item item = itemRegistry.value();
        String blockPath = provider.getItemPath(item, ApiBlockModelProvider.BLOCK_PREFIX);
        provider.cubeColumn(provider.getItemPath(item), ResourceUtils.parse(blockPath), ResourceUtils.parse(blockPath + "_top"));
    }
}
