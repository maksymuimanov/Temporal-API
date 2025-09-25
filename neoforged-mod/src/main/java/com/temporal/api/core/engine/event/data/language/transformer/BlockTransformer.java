package com.temporal.api.core.engine.event.data.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

public class BlockTransformer implements KeyTransformer<ResourceKey<Block>> {
    public static final String PREFIX = "block";

    @Override
    public String transform(ResourceKey<Block> block) {
        return this.transformResourceKey(PREFIX, block);
    }
}
