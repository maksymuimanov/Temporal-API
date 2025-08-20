package com.temporal.api.core.event.data.model.block;

import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

public class BarrelBlockModelProviderStrategy implements BlockModelProviderStrategy {
    @Override
    public void registerBlockModel(Holder<? extends Block> blockRegistry, ApiBlockModelProvider provider, String... additionalData) {
        Block block = blockRegistry.value();
        String blockPath = provider.getBlockPath(block);
        provider.simpleBlock(block, provider.models()
                .cubeBottomTop(blockPath, ResourceUtils.parse(blockPath + "_side"), ResourceUtils.parse(blockPath + "_bottom"), ResourceUtils.parse(blockPath + "_top")));
    }
}
