package com.temporal.api.core.event.data.model.block;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

public interface BlockModelProviderStrategy {
    void registerBlockModel(Holder<? extends Block> blockRegistry, ApiBlockModelProvider provider, String... additionalData);
}
