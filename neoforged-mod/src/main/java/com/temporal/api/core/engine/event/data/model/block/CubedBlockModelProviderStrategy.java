package com.temporal.api.core.engine.event.data.model.block;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

public class CubedBlockModelProviderStrategy implements BlockModelProviderStrategy {
    @Override
    public void registerBlockModel(Holder<? extends Block> blockRegistry, ApiBlockModelProvider provider, String... additionalData) {
        Block block = blockRegistry.value();
        provider.simpleBlock(block);
    }
}
