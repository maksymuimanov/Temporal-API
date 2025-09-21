package com.temporal.api.core.engine.event.data.model.block.strategy;

import com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.engine.event.data.model.block.spec.BlockModelSpec;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.world.level.block.DoorBlock;

public class DoorBlockModelProviderStrategy implements BlockModelProviderStrategy<BlockModelSpec> {
    @Override
    public void registerBlockModel(BlockModelSpec spec, ApiBlockModelProvider provider) {
        DoorBlock block = spec.getBlock();
        String blockPath = spec.getPath();
        provider.doorBlockWithRenderType(block, ResourceUtils.parse(blockPath + "_bottom"), ResourceUtils.parse(blockPath + "_top"), spec.getRenderType());
    }
}
