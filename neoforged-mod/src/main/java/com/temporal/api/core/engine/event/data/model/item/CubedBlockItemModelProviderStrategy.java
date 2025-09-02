package com.temporal.api.core.engine.event.data.model.item;

import com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class CubedBlockItemModelProviderStrategy implements ItemModelProviderStrategy {
    @Override
    public void registerItemModel(Holder<? extends Item> itemRegistry, ApiItemModelProvider provider, String... additionalData) {
        Item item = itemRegistry.value();
        String blockPath = provider.getItemPath(item, ApiBlockModelProvider.BLOCK_PREFIX);
        provider.cubeAll(provider.getItemPath(item), ResourceLocation.parse(blockPath));
    }
}
