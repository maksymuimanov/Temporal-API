package com.temporal.api.core.event.data.preparer.tag;

import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.common.Tags;

import java.util.*;

public final class EnchantmentTagDynamicPreparer extends AbstractTagDynamicPreparer<Enchantment> {
    public static final Set<Class<?>> TAG_CONTAINERS = new HashSet<>(List.of(EnchantmentTags.class, Tags.Enchantments.class));
    public static final Map<String, TagKey<Enchantment>> ENCHANTMENT_TAGS = new HashMap<>();

    @Override
    public Set<Class<?>> getTagContainers() {
        return TAG_CONTAINERS;
    }

    @Override
    public Map<String, TagKey<Enchantment>> getTags() {
        return ENCHANTMENT_TAGS;
    }
}
