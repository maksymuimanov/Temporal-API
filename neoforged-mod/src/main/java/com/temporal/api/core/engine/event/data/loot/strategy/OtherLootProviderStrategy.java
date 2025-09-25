package com.temporal.api.core.engine.event.data.loot.strategy;

import com.temporal.api.core.engine.event.data.loot.ApiBlockLootTableProvider;
import com.temporal.api.core.engine.event.data.loot.LootProviderStrategy;
import com.temporal.api.core.engine.event.data.loot.spec.OtherItemBlockLootTableSpec;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class OtherLootProviderStrategy implements LootProviderStrategy<OtherItemBlockLootTableSpec> {
    @Override
    public void generateLoot(OtherItemBlockLootTableSpec spec, ApiBlockLootTableProvider provider) {
        Block block = spec.getBlock();
        Item item = spec.getOtherItem();
        provider.dropOther(block, item);
    }
}
