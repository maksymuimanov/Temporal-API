package com.temporal.api.core.engine.event.data.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

public class BlockItemTransformer implements KeyTransformer<ResourceKey<Block>> {
    @Override
    public String transform(ResourceKey<Block> block) {
        return this.transformResourceKey(ItemTransformer.PREFIX, block);
    }
}
