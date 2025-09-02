package com.temporal.api.core.engine.event.data.loot;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

public interface LootProviderStrategy {
    void generateLoot(Holder<? extends Block> blockRegistry, ApiBlockLootTableProvider provider, String... additionalData);
}
