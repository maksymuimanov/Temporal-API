package com.temporal.api.core.engine.event.data.model.block.strategy;

import com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.engine.event.data.model.block.spec.BlockModelSpec;
import net.minecraft.world.level.block.Block;

public class CarpetBlockModelProviderStrategy implements BlockModelProviderStrategy<BlockModelSpec> {
    public static final String MODEL_PARENT = "block/carpet";
    public static final String WOOL_KEY = "wool";

    @Override
    public void registerBlockModel(BlockModelSpec spec, ApiBlockModelProvider provider) {
        Block block = spec.getBlock();
        String blockPath = spec.getPath();
        provider.simpleBlock(block, provider.models()
                .withExistingParent(blockPath, MODEL_PARENT)
                .texture(WOOL_KEY, blockPath)
                .renderType(spec.getRenderType()));
    }
}
