package com.temporal.api.core.event.data.loot;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.entries.LootItem;

public class ShearsOnlyLootProviderStrategy implements LootProviderStrategy {
    @Override
    public void generateLoot(Holder<? extends Block> blockRegistry, ApiBlockLootTableProvider provider, String... additionalData) {
        Block block = blockRegistry.value();
        provider.add(block, provider.createShearsDispatchTable(block, provider.applyExplosionDecay(block, LootItem.lootTableItem(block))));
    }
}
