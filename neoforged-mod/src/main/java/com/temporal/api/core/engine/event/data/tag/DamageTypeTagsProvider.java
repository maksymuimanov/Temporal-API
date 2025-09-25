package com.temporal.api.core.engine.event.data.tag;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DamageTypeTagsProvider extends AbstractTagsProvider<DamageType> {
    public static final Map<String, List<ResourceKey<DamageType>>> TAG_GENERATION_DESCRIPTIONS = new HashMap<>();
    public static final String ROOT_DIRECTORY = "tags/damage_type/";

    public DamageTypeTagsProvider(PackOutput output) {
        super(output, ROOT_DIRECTORY);
    }

    @Override
    protected Map<String, List<ResourceKey<DamageType>>> getTagContents() {
        return TAG_GENERATION_DESCRIPTIONS;
    }
}
