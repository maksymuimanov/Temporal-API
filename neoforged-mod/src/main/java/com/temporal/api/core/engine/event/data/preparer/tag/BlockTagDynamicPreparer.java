package com.temporal.api.core.engine.event.data.preparer.tag;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;

import java.util.*;

public final class BlockTagDynamicPreparer extends AbstractTagDynamicPreparer<Block> {
    public static final Set<Class<?>> TAG_CONTAINERS = new HashSet<>(List.of(BlockTags.class, Tags.Blocks.class));
    public static final Map<String, TagKey<Block>> BLOCK_TAGS = new HashMap<>();

    @Override
    public Set<Class<?>> getTagContainers() {
        return TAG_CONTAINERS;
    }

    @Override
    public Map<String, TagKey<Block>> getTags() {
        return BLOCK_TAGS;
    }
}
