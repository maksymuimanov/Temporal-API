package com.temporal.api.core.event.data.model.block;

import com.temporal.api.core.util.other.ResourceUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;

public class LogBlockModelProviderStrategy implements BlockModelProviderStrategy {
    @Override
    public void registerBlockModel(Holder<? extends Block> blockRegistry, ApiBlockModelProvider provider, String... additionalData) {
        RotatedPillarBlock block = ((RotatedPillarBlock) blockRegistry.value());
        String logBlockPath = provider.getBlockPath(block);
        provider.axisBlock(block, ResourceUtils.parse(logBlockPath), ResourceUtils.parse(logBlockPath + "_top"));
    }
}
