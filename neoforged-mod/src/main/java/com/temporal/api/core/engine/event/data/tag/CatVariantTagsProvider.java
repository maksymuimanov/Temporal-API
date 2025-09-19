package com.temporal.api.core.engine.event.data.tag;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.CatVariant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatVariantTagsProvider extends AbstractTagsProvider<CatVariant> {
    public static final Map<String, List<ResourceKey<CatVariant>>> TAG_GENERATION_DESCRIPTIONS = new HashMap<>();
    public static final String ROOT_DIRECTORY = "tags/cat_variants/";

    public CatVariantTagsProvider(PackOutput output) {
        super(output, ROOT_DIRECTORY);
    }

    @Override
    protected Map<String, List<ResourceKey<CatVariant>>> getTagContents() {
        return TAG_GENERATION_DESCRIPTIONS;
    }
}
