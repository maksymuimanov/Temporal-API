package com.temporal.api.core.engine.event.data.model.block.strategy;

import com.temporal.api.core.engine.event.data.model.ModelConstants;
import com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.engine.event.data.model.block.spec.BlockModelSpec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class BarrelBlockModelProviderStrategy implements BlockModelProviderStrategy<BlockModelSpec> {
    @Override
    public void registerBlockModel(BlockModelSpec spec, ApiBlockModelProvider provider) {
        Block block = spec.getBlock();
        String blockPath = spec.getPath();
        ResourceLocation sideTexture = spec.getLocation(ModelConstants.SIDE_SUFFIX);
        ResourceLocation bottomTexture = spec.getLocation(ModelConstants.BOTTOM_SUFFIX);
        ResourceLocation topTexture = spec.getLocation(ModelConstants.TOP_SUFFIX);
        provider.simpleBlock(block, provider.models()
                .cubeBottomTop(blockPath, sideTexture, bottomTexture, topTexture)
                .renderType(spec.getRenderType()));
    }
}
