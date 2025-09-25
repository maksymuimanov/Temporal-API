package com.temporal.api.core.engine.event.data.loot;

import com.temporal.api.core.engine.event.data.loot.spec.BlockLootTableSpec;

public interface LootProviderStrategy<T extends BlockLootTableSpec> {
    void generateLoot(T spec, ApiBlockLootTableProvider provider);
}
