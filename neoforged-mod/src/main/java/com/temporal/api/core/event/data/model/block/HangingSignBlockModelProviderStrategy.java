package com.temporal.api.core.event.data.model.block;

import com.temporal.api.core.util.RegistryUtils;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;

public class HangingSignBlockModelProviderStrategy implements BlockModelProviderStrategy {
    @Override
    public void registerBlockModel(Holder<? extends Block> blockRegistry, ApiBlockModelProvider provider, String... additionalData) {
        CeilingHangingSignBlock block = (CeilingHangingSignBlock) blockRegistry.value();
        WallHangingSignBlock wallBlock = (WallHangingSignBlock) RegistryUtils.getBlockById(additionalData[0]);
        provider.hangingSignBlock(block, wallBlock, ResourceUtils.parse(additionalData[1]));
    }
}
