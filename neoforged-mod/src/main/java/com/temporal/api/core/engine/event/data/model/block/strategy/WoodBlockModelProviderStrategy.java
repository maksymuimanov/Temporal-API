package com.temporal.api.core.engine.event.data.model.block.strategy;

import com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.engine.event.data.model.block.spec.BlockModelSpec;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.RotatedPillarBlock;

public class WoodBlockModelProviderStrategy implements BlockModelProviderStrategy<BlockModelSpec> {
    @Override
    public void registerBlockModel(BlockModelSpec spec, ApiBlockModelProvider provider) {
        RotatedPillarBlock block = spec.getBlock();
        String logBlockPath = spec.getPath().replace("wood", "log");
        ResourceLocation texture = ResourceUtils.parse(logBlockPath);
        provider.axisBlockWithRenderType(block, texture, texture, spec.getRenderType());
    }
}
