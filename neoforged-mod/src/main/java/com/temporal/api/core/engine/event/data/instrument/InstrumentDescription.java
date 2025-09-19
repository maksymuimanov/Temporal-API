package com.temporal.api.core.engine.event.data.instrument;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Instrument;

public record InstrumentDescription(ResourceKey<Instrument> instrument, String soundEvent, int useDuration, float range) {
}
