package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Instrument;
import net.neoforged.neoforge.registries.DeferredHolder;

public class InstrumentFactory extends AbstractObjectFactory<Instrument> {
    public InstrumentFactory() {
        this(InjectionPool.getFromInstance("$Instruments"));
    }

    public InstrumentFactory(TemporalRegister<Instrument> register) {
        super(register);
    }

    public DeferredHolder<Instrument, Instrument> create(String name, Holder<SoundEvent> soundEvent, int useDuration, float range) {
        return this.create(name, () -> new Instrument(soundEvent, useDuration, range));
    }
}
