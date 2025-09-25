package com.temporal.api.core.engine.event.data.tag;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BiomeTagsProvider extends AbstractTagsProvider<Biome> {
    public static final Map<String, List<ResourceKey<Biome>>> TAG_GENERATION_DESCRIPTIONS = new HashMap<>();
    public static final String ROOT_DIRECTORY = "tags/worldgen/biome/";

    public BiomeTagsProvider(PackOutput output) {
        super(output, ROOT_DIRECTORY);
    }

    @Override
    protected Map<String, List<ResourceKey<Biome>>> getTagContents() {
        return TAG_GENERATION_DESCRIPTIONS;
    }
}
