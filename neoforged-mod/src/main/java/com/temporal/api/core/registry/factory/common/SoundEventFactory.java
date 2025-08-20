package com.temporal.api.core.registry.factory.common;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SoundEventFactory extends AbstractObjectFactory<SoundEvent> {
    private final DeferredRegister<SoundEvent> soundEvents;

    public SoundEventFactory() {
        this(InjectionPool.getFromInstance("$SoundEvents"));
    }

    public SoundEventFactory(DeferredRegister<SoundEvent> soundEvents) {
        this.soundEvents = soundEvents;
    }

    public DeferredHolder<SoundEvent, SoundEvent> create(String name) {
        return create(name, () -> SoundEvent.createVariableRangeEvent(ResourceUtils.parse(name)));
    }

    @Override
    public DeferredRegister<SoundEvent> getRegistry() {
        return soundEvents;
    }
}
