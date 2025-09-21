package com.temporal.api.core.engine.event.data.model.block.strategy;

import com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider;
import com.temporal.api.core.engine.event.data.model.block.spec.BlockModelSpec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;

public class CubedBlockModelProviderStrategy implements BlockModelProviderStrategy<BlockModelSpec> {
    @Override
    public void registerBlockModel(BlockModelSpec spec, ApiBlockModelProvider provider) {
        Block block = spec.getBlock();
        provider.simpleBlock(block, provider.models()
                .cubeAll(BuiltInRegistries.BLOCK.getKey(block).getPath(), provider.blockTexture(block))
                .renderType(spec.getRenderType()));
    }
}
