package com.temporal.api.core.engine.event.data.model.block;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;

import static com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider.MINECRAFT_CUTOUT;

public class WallBlockModelProviderStrategy implements BlockModelProviderStrategy {
    @Override
    public void registerBlockModel(Holder<? extends Block> blockRegistry, ApiBlockModelProvider provider, String... additionalData) {
        provider.familyMember((WallBlock) blockRegistry.value(), additionalData[0],
                (block, parentTexture) -> provider.wallBlockWithRenderType(block, parentTexture, MINECRAFT_CUTOUT));
    }
}
