package com.temporal.api.core.event.data.loot;

import com.temporal.api.core.util.RegistryUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class MushroomBlockLootProviderStrategy implements LootProviderStrategy {
    @Override
    public void generateLoot(Holder<? extends Block> blockRegistry, ApiBlockLootTableProvider provider, String... additionalData) {
        Block block = blockRegistry.value();
        String itemId = additionalData[0];
        Item item = RegistryUtils.getItem(itemId);
        provider.add(block, provider.createMushroomBlockDrop(block, item));
    }
}
