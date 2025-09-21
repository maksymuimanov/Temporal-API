package com.temporal.api.core.engine.event.data.model.block.strategy;

import com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.engine.event.data.model.block.spec.BlockModelSpec;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.world.level.block.Block;

public class BarrelBlockModelProviderStrategy implements BlockModelProviderStrategy<BlockModelSpec> {
    @Override
    public void registerBlockModel(BlockModelSpec spec, ApiBlockModelProvider provider) {
        Block block = spec.getBlock();
        String blockPath = spec.getPath();
        provider.simpleBlock(block, provider.models()
                .cubeBottomTop(blockPath, ResourceUtils.parse(blockPath + "_side"), ResourceUtils.parse(blockPath + "_bottom"), ResourceUtils.parse(blockPath + "_top"))
                .renderType(spec.getRenderType()));
    }
}
