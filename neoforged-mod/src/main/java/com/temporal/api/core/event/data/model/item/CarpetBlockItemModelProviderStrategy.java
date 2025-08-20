package com.temporal.api.core.event.data.model.item;

import com.temporal.api.core.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.util.other.RegistryUtils;
import com.temporal.api.core.util.other.ResourceUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CarpetBlockItemModelProviderStrategy implements ItemModelProviderStrategy {
    @Override
    public void registerItemModel(Holder<? extends Item> itemRegistry, ApiItemModelProvider provider, String... additionalData) {
        Item item = itemRegistry.value();
        Block block = RegistryUtils.getBlockById(additionalData[0]);
        String blockPath = provider.getItemPath(block.asItem(), ApiBlockModelProvider.BLOCK_PREFIX);
        provider.carpet(provider.getItemPath(item), ResourceUtils.parse(blockPath));
    }
}
