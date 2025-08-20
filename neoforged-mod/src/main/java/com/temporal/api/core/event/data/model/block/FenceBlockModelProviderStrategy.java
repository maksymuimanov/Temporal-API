package com.temporal.api.core.event.data.model.block;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;

import static com.temporal.api.core.event.data.model.block.ApiBlockModelProvider.MINECRAFT_CUTOUT;

public class FenceBlockModelProviderStrategy implements BlockModelProviderStrategy {
    @Override
    public void registerBlockModel(Holder<? extends Block> blockRegistry, ApiBlockModelProvider provider, String... additionalData) {
        provider.familyMember((FenceBlock) blockRegistry.value(), additionalData[0],
                (block, parentTexture) -> provider.fenceBlockWithRenderType(block, parentTexture, MINECRAFT_CUTOUT));
    }
}
