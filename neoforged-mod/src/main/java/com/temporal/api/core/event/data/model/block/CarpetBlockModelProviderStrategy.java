package com.temporal.api.core.event.data.model.block;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

public class CarpetBlockModelProviderStrategy implements BlockModelProviderStrategy {
    @Override
    public void registerBlockModel(Holder<? extends Block> blockRegistry, ApiBlockModelProvider provider, String... additionalData) {
        Block block = blockRegistry.value();
        String blockPath = provider.getBlockPath(block);
        provider.simpleBlock(block, provider.models()
                .withExistingParent(blockPath, "block/carpet")
                .texture("wool", blockPath));
    }
}
