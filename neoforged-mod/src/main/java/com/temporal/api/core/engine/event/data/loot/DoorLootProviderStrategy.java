package com.temporal.api.core.engine.event.data.loot;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

public class DoorLootProviderStrategy implements LootProviderStrategy {
    @Override
    public void generateLoot(Holder<? extends Block> blockRegistry, ApiBlockLootTableProvider provider, String... additionalData) {
        Block block = blockRegistry.value();
        provider.add(block, provider.createDoorTable(block));
    }
}
