package com.temporal.api.core.event.data.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

public class BlockTransformer implements KeyTransformer<ResourceKey<Block>> {
    @Override
    public String transform(ResourceKey<Block> block) {
        return this.transformResourceKey("block", block);
    }
}
