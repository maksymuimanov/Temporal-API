package com.temporal.api.core.event.data.preparer.tag.block;

import com.temporal.api.core.event.data.preparer.DynamicPreparer;
import com.temporal.api.core.util.other.TagUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;

import java.util.*;

public final class BlockTagDynamicPreparer implements DynamicPreparer {
    public static final Set<Class<?>> TAG_CONTAINERS = new HashSet<>(List.of(BlockTags.class, Tags.Blocks.class));
    public static final Map<String, TagKey<Block>> BLOCK_TAGS = new HashMap<>();

    @Override
    public void prepare() {
        TAG_CONTAINERS.stream()
                .flatMap(TagUtils::<Block>getTagKeyStream)
                .forEach(tag -> TagUtils.putTagKey(tag, BLOCK_TAGS));
    }
}
