package com.temporal.api.core.engine.event.data.tag;

import com.temporal.api.core.util.TagUtils;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Instrument;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InstrumentTagsProvider extends AbstractTagsProvider<Instrument> {
    public static final Map<String, List<Holder<? extends Instrument>>> TAG_GENERATION_DESCRIPTIONS = new HashMap<>();
    public static final String ROOT_DIRECTORY = "tags/instrument/";

    public InstrumentTagsProvider(PackOutput output) {
        super(output, ROOT_DIRECTORY);
    }

    @Override
    protected Map<String, List<ResourceKey<Instrument>>> getTagContents() {
        return TagUtils.mapTagHolderMap(TAG_GENERATION_DESCRIPTIONS);
    }
}
