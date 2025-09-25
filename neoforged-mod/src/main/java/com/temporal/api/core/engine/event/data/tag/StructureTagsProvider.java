package com.temporal.api.core.engine.event.data.tag;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StructureTagsProvider extends AbstractTagsProvider<Structure> {
    public static final Map<String, List<ResourceKey<Structure>>> TAG_GENERATION_DESCRIPTIONS = new HashMap<>();
    public static final String ROOT_DIRECTORY = "tags/worldgen/structure/";

    public StructureTagsProvider(PackOutput output) {
        super(output, ROOT_DIRECTORY);
    }

    @Override
    protected Map<String, List<ResourceKey<Structure>>> getTagContents() {
        return TAG_GENERATION_DESCRIPTIONS;
    }
}
