package com.temporal.api.core.engine.event.data.tag;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.BannerPattern;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BannerPatternTagsProvider extends AbstractTagsProvider<BannerPattern> {
    public static final Map<String, List<ResourceKey<BannerPattern>>> TAG_GENERATION_DESCRIPTIONS = new HashMap<>();
    public static final String ROOT_DIRECTORY = "tags/banner_pattern/";

    public BannerPatternTagsProvider(PackOutput output) {
        super(output, ROOT_DIRECTORY);
    }

    @Override
    protected Map<String, List<ResourceKey<BannerPattern>>> getTagContents() {
        return TAG_GENERATION_DESCRIPTIONS;
    }
}
