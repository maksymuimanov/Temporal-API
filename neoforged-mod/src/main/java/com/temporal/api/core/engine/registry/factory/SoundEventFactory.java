package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

public class SoundEventFactory extends AbstractObjectFactory<SoundEvent> {
    public SoundEventFactory() {
        this(InjectionPool.getFromInstance("$SoundEvents"));
    }

    public SoundEventFactory(TemporalRegister<SoundEvent> soundEvents) {
        super(soundEvents);
    }

    public DeferredHolder<SoundEvent, SoundEvent> create(String name) {
        return this.create(name, () -> SoundEvent.createVariableRangeEvent(ResourceUtils.parse(name)));
    }

    public DeferredHolder<SoundEvent, SoundEvent> create(String name, float fixedRate) {
        return this.create(name, () -> SoundEvent.createFixedRangeEvent(ResourceUtils.parse(name), fixedRate));
    }
}
