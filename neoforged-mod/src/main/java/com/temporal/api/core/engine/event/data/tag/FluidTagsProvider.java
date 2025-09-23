package com.temporal.api.core.engine.event.data.tag;

import com.temporal.api.core.util.TagUtils;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.material.Fluid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FluidTagsProvider extends AbstractTagsProvider<Fluid> {
    public static final Map<String, List<Holder<? extends Fluid>>> TAG_GENERATION_DESCRIPTIONS = new HashMap<>();
    public static final String ROOT_DIRECTORY = "tags/fluid/";

    public FluidTagsProvider(PackOutput output) {
        super(output, ROOT_DIRECTORY);
    }

    @Override
    protected Map<String, List<ResourceKey<Fluid>>> getTagContents() {
        return TagUtils.mapTagHolderMap(TAG_GENERATION_DESCRIPTIONS);
    }
}
