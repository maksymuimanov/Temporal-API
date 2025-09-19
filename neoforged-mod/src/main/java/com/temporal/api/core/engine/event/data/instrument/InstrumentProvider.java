package com.temporal.api.core.engine.event.data.instrument;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.Instrument;

public interface InstrumentProvider {
    void addInstrument(BootstrapContext<Instrument> context);
}
