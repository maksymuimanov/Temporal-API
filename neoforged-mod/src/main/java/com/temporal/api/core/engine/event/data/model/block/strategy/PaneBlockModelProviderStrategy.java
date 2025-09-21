package com.temporal.api.core.engine.event.data.model.block.strategy;

import com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.engine.event.data.model.block.spec.BlockModelSpec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class PaneBlockModelProviderStrategy implements BlockModelProviderStrategy<BlockModelSpec> {
    @Override
    public void registerBlockModel(BlockModelSpec spec, ApiBlockModelProvider provider) {
        Block block = spec.getBlock();
        String blockPath = spec.getPath();
        ResourceLocation paneTexture = spec.getLocation();
        ResourceLocation edgeTexture = spec.getLocation("_top");
        provider.simpleBlock(block, provider.models()
                .paneNoSide(blockPath, paneTexture)
                .renderType(spec.getRenderType()));
        provider.simpleBlock(block, provider.models()
                .paneNoSideAlt(blockPath, paneTexture)
                .renderType(spec.getRenderType()));
        provider.simpleBlock(block, provider.models()
                .panePost(blockPath, paneTexture, edgeTexture)
                .renderType(spec.getRenderType()));
        provider.simpleBlock(block, provider.models()
                .paneSide(blockPath, paneTexture, edgeTexture)
                .renderType(spec.getRenderType()));
        provider.simpleBlock(block, provider.models()
                .paneSideAlt(blockPath, paneTexture, edgeTexture)
                .renderType(spec.getRenderType()));
    }
}
