package com.temporal.api.core.engine.event.data.model.block;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;

import static com.temporal.api.core.engine.event.data.model.block.ApiBlockModelProvider.MINECRAFT_CUTOUT;

public class CutoutCubedBlockModelProviderStrategy implements BlockModelProviderStrategy {
    @Override
    public void registerBlockModel(Holder<? extends Block> blockRegistry, ApiBlockModelProvider provider, String... additionalData) {
        Block block = blockRegistry.value();
        provider.simpleBlock(block, provider.models()
                .cubeAll(BuiltInRegistries.BLOCK.getKey(block).getPath(), provider.blockTexture(block))
                .renderType(MINECRAFT_CUTOUT));
    }
}
