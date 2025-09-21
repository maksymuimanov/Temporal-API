package com.temporal.api.core.engine.event.data.model.block.strategy;

import com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.engine.event.data.model.block.spec.BlockModelSpec;
import net.minecraft.world.level.block.Block;

public class RailBlockModelProviderStrategy implements BlockModelProviderStrategy<BlockModelSpec> {
    @Override
    public void registerBlockModel(BlockModelSpec spec, ApiBlockModelProvider provider) {
        Block block = spec.getBlock();
        String blockPath = spec.getPath();
        provider.simpleBlock(block, provider.models()
                .withExistingParent(blockPath, "block/rail_flat")
                .texture("rail", blockPath)
                .renderType(spec.getRenderType()));
    }
}
