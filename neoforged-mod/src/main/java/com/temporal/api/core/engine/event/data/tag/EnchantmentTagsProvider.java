package com.temporal.api.core.engine.event.data.tag;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnchantmentTagsProvider extends AbstractTagsProvider<Enchantment> {
    public static final Map<String, List<ResourceKey<Enchantment>>> TAG_GENERATION_DESCRIPTIONS = new HashMap<>();
    public static final String ROOT_DIRECTORY = "tags/enchantment/";

    public EnchantmentTagsProvider(PackOutput output) {
        super(output, ROOT_DIRECTORY);
    }

    @Override
    protected Map<String, List<ResourceKey<Enchantment>>> getTagContents() {
        return TAG_GENERATION_DESCRIPTIONS;
    }
}
