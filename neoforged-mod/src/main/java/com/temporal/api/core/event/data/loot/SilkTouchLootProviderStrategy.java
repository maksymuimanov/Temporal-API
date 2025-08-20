package com.temporal.api.core.event.data.loot;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

public class SilkTouchLootProviderStrategy implements LootProviderStrategy {
    @Override
    public void generateLoot(Holder<? extends Block> blockRegistry, ApiBlockLootTableProvider provider, String... additionalData) {
        provider.dropWhenSilkTouch(blockRegistry.value());
    }
}
