package com.temporal.api.core.engine.event.data.loot.strategy;

import com.temporal.api.core.engine.event.data.loot.ApiBlockLootTableProvider;
import com.temporal.api.core.engine.event.data.loot.LootProviderStrategy;
import com.temporal.api.core.engine.event.data.loot.spec.BlockLootTableSpec;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;

public class BannerLootProviderStrategy implements LootProviderStrategy<BlockLootTableSpec> {
    @Override
    public void generateLoot(BlockLootTableSpec spec, ApiBlockLootTableProvider provider) {
        Block block = spec.getBlock();
        LootTable.Builder builder = provider.createBannerDrop(block);
        provider.add(block, builder);
    }
}
