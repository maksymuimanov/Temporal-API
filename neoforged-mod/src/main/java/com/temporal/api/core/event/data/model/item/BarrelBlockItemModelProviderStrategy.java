package com.temporal.api.core.event.data.model.item;

import com.temporal.api.core.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

public class BarrelBlockItemModelProviderStrategy implements ItemModelProviderStrategy {
    @Override
    public void registerItemModel(Holder<? extends Item> itemRegistry, ApiItemModelProvider provider, String... additionalData) {
        Item item = itemRegistry.value();
        String blockPath = provider.getItemPath(item, ApiBlockModelProvider.BLOCK_PREFIX);
        provider.cubeBottomTop(provider.getItemPath(item), ResourceUtils.parse(blockPath + "_side"), ResourceUtils.parse(blockPath + "_bottom"), ResourceUtils.parse(blockPath + "_top"));
    }
}
