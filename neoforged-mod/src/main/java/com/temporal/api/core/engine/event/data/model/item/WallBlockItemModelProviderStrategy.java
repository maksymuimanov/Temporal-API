package com.temporal.api.core.engine.event.data.model.item;

import com.temporal.api.core.engine.event.data.model.block.spec.BlockModelSpec;
import com.temporal.api.core.util.RegistryUtils;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class WallBlockItemModelProviderStrategy implements ItemModelProviderStrategy {
    @Override
    public void registerItemModel(Holder<? extends Item> itemRegistry, ApiItemModelProvider provider, String... additionalData) {
        Item item = itemRegistry.value();
        Block block = RegistryUtils.getBlock(additionalData[0]);
        String blockPath = provider.getItemPath(block.asItem(), BlockModelSpec.BLOCK_PREFIX);
        provider.wallInventory(provider.getItemPath(item), ResourceUtils.parse(blockPath));
    }
}
