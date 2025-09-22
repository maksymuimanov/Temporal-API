package com.temporal.api.core.engine.event.data.loot.strategy;

import com.temporal.api.core.engine.event.data.loot.ApiBlockLootTableProvider;
import com.temporal.api.core.engine.event.data.loot.LootProviderStrategy;
import com.temporal.api.core.engine.event.data.loot.spec.BlockLootTableSpec;
import net.minecraft.world.level.block.Block;

public class ShulkerBoxLootProviderStrategy implements LootProviderStrategy<BlockLootTableSpec> {
    @Override
    public void generateLoot(BlockLootTableSpec spec, ApiBlockLootTableProvider provider) {
        Block block = spec.getBlock();
        provider.add(block, provider.createShulkerBoxDrop(block));
    }
}
