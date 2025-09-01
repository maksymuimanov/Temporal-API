package com.temporal.api.core.event.data.preparer.tag;

import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.common.Tags;

import java.util.*;

public final class BiomeTagDynamicPreparer extends AbstractTagDynamicPreparer<Biome> {
    public static final Set<Class<?>> TAG_CONTAINERS = new HashSet<>(List.of(BiomeTags.class, Tags.Biomes.class));
    public static final Map<String, TagKey<Biome>> BIOME_TAGS = new HashMap<>();

    @Override
    public Set<Class<?>> getTagContainers() {
        return TAG_CONTAINERS;
    }

    @Override
    public Map<String, TagKey<Biome>> getTags() {
        return BIOME_TAGS;
    }
}
