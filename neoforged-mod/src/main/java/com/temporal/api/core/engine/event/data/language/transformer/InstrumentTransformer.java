package com.temporal.api.core.engine.event.data.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Instrument;

public class InstrumentTransformer implements KeyTransformer<ResourceKey<Instrument>> {
    @Override
    public String transform(ResourceKey<Instrument> instrument) {
        return this.transformResourceKey("instrument", instrument);
    }
}
