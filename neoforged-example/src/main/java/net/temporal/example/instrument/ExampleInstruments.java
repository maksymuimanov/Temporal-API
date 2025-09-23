package net.temporal.example.instrument;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.metadata.annotation.data.tag.AddInstrumentTag;
import com.temporal.api.core.engine.registry.factory.InstrumentFactory;
import net.minecraft.world.item.Instrument;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.temporal.example.sound.ExampleSounds;

public final class ExampleInstruments {
    private static final InstrumentFactory INSTRUMENT_FACTORY = InjectionPool.getFromInstance(InstrumentFactory.class);

    @AddInstrumentTag("example:example")
    public static final DeferredHolder<Instrument, Instrument> EXAMPLE = INSTRUMENT_FACTORY.create("example", ExampleSounds.EXAMPLE_SOUND, 10, 15f);
}
