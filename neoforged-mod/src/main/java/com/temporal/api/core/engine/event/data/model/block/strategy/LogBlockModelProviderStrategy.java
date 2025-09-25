package com.temporal.api.core.engine.event.data.model.block.strategy;

import com.temporal.api.core.engine.event.data.model.ModelConstants;
import com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.engine.event.data.model.block.spec.BlockModelSpec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.RotatedPillarBlock;

public class LogBlockModelProviderStrategy implements BlockModelProviderStrategy<BlockModelSpec> {
    @Override
    public void registerBlockModel(BlockModelSpec spec, ApiBlockModelProvider provider) {
        RotatedPillarBlock block = spec.getBlock();
        ResourceLocation sideTexture = spec.getLocation();
        ResourceLocation endTexture = spec.getLocation(ModelConstants.TOP_SUFFIX);
        provider.axisBlockWithRenderType(block, sideTexture, endTexture, spec.getRenderType());
    }
}