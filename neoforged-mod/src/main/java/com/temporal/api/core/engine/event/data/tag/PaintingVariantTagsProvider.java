package com.temporal.api.core.engine.event.data.tag;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaintingVariantTagsProvider extends AbstractTagsProvider<PaintingVariant> {
    public static final Map<String, List<ResourceKey<PaintingVariant>>> TAG_GENERATION_DESCRIPTIONS = new HashMap<>();
    public static final String ROOT_DIRECTORY = "tags/painting_variant/";

    public PaintingVariantTagsProvider(PackOutput output) {
        super(output, ROOT_DIRECTORY);
    }

    @Override
    protected Map<String, List<ResourceKey<PaintingVariant>>> getTagContents() {
        return TAG_GENERATION_DESCRIPTIONS;
    }
}
