package com.temporal.api.core.event.data.model.block;

import com.temporal.api.core.util.RegistryUtils;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;

public class SignBlockModelProviderStrategy implements BlockModelProviderStrategy {
    @Override
    public void registerBlockModel(Holder<? extends Block> blockRegistry, ApiBlockModelProvider provider, String... additionalData) {
        StandingSignBlock block = (StandingSignBlock) blockRegistry.value();
        WallSignBlock wallBlock = (WallSignBlock) RegistryUtils.getBlockById(additionalData[0]);
        provider.signBlock(block, wallBlock, ResourceUtils.parse(additionalData[1]));
    }
}
