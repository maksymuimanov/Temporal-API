package com.temporal.api.core.engine.event.data.instrument;

import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.util.RegistryUtils;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Instrument;

import java.util.Queue;

public class ApiInstrumentProvider implements InstrumentProvider {
    public static final Queue<InstrumentDescription> INSTRUMENTS = new TemporalQueue<>();

    @Override
    public void addInstrument(BootstrapContext<Instrument> context) {
        INSTRUMENTS.forEach(description -> {
            ResourceKey<Instrument> instrument = description.instrument();
            SoundEvent soundEvent = RegistryUtils.getSoundEvent(description.soundEvent());
            context.register(instrument, new Instrument(Holder.direct(soundEvent), description.useDuration(), description.range()));
        });
    }

    public static void bootstrap(BootstrapContext<Instrument> context) {
        InstrumentProvider provider = new ApiInstrumentProvider();
        provider.addInstrument(context);
    }
}
