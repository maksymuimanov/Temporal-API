package net.temporal.example.instrument;

import com.temporal.api.core.util.TagUtils;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Instrument;

public class ExampleInstrumentTags {
    public static final TagKey<Instrument> EXAMPLE = TagUtils.createInstrument("example");
}
