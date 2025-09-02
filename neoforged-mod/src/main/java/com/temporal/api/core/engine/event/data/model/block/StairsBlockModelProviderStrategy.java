package com.temporal.api.core.engine.event.data.model.block;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;

public class StairsBlockModelProviderStrategy implements BlockModelProviderStrategy {
    @Override
    public void registerBlockModel(Holder<? extends Block> blockRegistry, ApiBlockModelProvider provider, String... additionalData) {
        provider.familyMember((StairBlock) blockRegistry.value(), additionalData[0],
                provider::stairsBlock);
    }
}
