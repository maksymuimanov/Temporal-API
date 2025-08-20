package com.temporal.api.core.event.data.loot;

import com.temporal.api.core.util.other.RegistryUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

public class LeavesLootProviderStrategy implements LootProviderStrategy {
    @Override
    public void generateLoot(Holder<? extends Block> blockRegistry, ApiBlockLootTableProvider provider, String... additionalData) {
        Block block = blockRegistry.value();
        String saplingBlockId = additionalData[0];
        Block saplingBlock = RegistryUtils.getBlockById(saplingBlockId);
        float[] chances = new float[additionalData.length - 1];
        for (int i = 1; i < additionalData.length; i++) {
            float chance = Float.parseFloat(additionalData[i]);
            chances[i - 1] = chance;
        }

        provider.add(block, provider.createLeavesDrops(block, saplingBlock, chances));
    }
}
