package com.temporal.api.core.event.data.preparer.tag.enchantment;

import com.temporal.api.core.event.data.preparer.DynamicPreparer;
import com.temporal.api.core.util.other.TagUtils;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.common.Tags;

import java.util.*;

public final class EnchantmentTagDynamicPreparer implements DynamicPreparer {
    public static final Set<Class<?>> TAG_CONTAINERS = new HashSet<>(List.of(EnchantmentTags.class, Tags.Enchantments.class));
    public static final Map<String, TagKey<Enchantment>> ENCHANTMENT_TAGS = new HashMap<>();

    @Override
    public void prepare() {
        TAG_CONTAINERS.stream()
                .flatMap(TagUtils::<Enchantment>getTagKeyStream)
                .forEach(tag -> TagUtils.putTagKey(tag, ENCHANTMENT_TAGS));
    }
}
