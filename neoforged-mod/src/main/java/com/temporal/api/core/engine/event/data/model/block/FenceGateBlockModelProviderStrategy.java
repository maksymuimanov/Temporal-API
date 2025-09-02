package com.temporal.api.core.engine.event.data.model.block;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceGateBlock;

import static com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider.MINECRAFT_CUTOUT;

public class FenceGateBlockModelProviderStrategy implements BlockModelProviderStrategy {
    @Override
    public void registerBlockModel(Holder<? extends Block> blockRegistry, ApiBlockModelProvider provider, String... additionalData) {
        provider.familyMember((FenceGateBlock) blockRegistry.value(), additionalData[0],
                (block, parentTexture) -> provider.fenceGateBlockWithRenderType(block, parentTexture, MINECRAFT_CUTOUT));
    }
}
