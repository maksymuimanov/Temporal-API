package com.temporal.api.core.engine.event.data.loot;

import com.temporal.api.core.util.RegistryUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class OtherLootProviderStrategy implements LootProviderStrategy {
    @Override
    public void generateLoot(Holder<? extends Block> blockRegistry, ApiBlockLootTableProvider provider, String... additionalData) {
        Block block = blockRegistry.value();
        String otherId = additionalData[0];
        Item item = RegistryUtils.getItem(otherId);
        provider.dropOther(block, item);
    }
}
