package com.temporal.api.core.event.data.model.item;

import com.temporal.api.core.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.util.RegistryUtils;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class SlabBlockItemModelProviderStrategy implements ItemModelProviderStrategy {
    @Override
    public void registerItemModel(Holder<? extends Item> itemRegistry, ApiItemModelProvider provider, String... additionalData) {
        Item item = itemRegistry.value();
        Block block = RegistryUtils.getBlockById(additionalData[0]);
        String blockPath = provider.getItemPath(block.asItem(), ApiBlockModelProvider.BLOCK_PREFIX);
        provider.slab(provider.getItemPath(item), ResourceUtils.parse(blockPath), ResourceUtils.parse(blockPath), ResourceUtils.parse(blockPath));
    }
}
