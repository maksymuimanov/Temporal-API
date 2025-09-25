package com.temporal.api.core.engine.event.data.model.block.strategy;

import com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.engine.event.data.model.block.spec.BlockModelSpec;
import net.minecraft.world.level.block.Block;

public class VineBlockModelProviderStrategy implements BlockModelProviderStrategy<BlockModelSpec> {
    public static final String MODEL_PARENT = "block/vine";
    public static final String VINE_KEY = "vine";
    public static final String PARTICLE_KEY = "particle";

    @Override
    public void registerBlockModel(BlockModelSpec spec, ApiBlockModelProvider provider) {
        Block block = spec.getBlock();
        String blockPath = spec.getPath();
        provider.simpleBlock(block, provider.models()
                .withExistingParent(blockPath, MODEL_PARENT)
                .texture(VINE_KEY, blockPath)
                .texture(PARTICLE_KEY, blockPath)
                .renderType(spec.getRenderType()));
    }
}
