package com.temporal.api.core.engine.event.data.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;

public class SoundEventTransformer implements KeyTransformer<ResourceKey<SoundEvent>> {
    @Override
    public String transform(ResourceKey<SoundEvent> soundEvent) {
        return this.transformResourceKey("sound", soundEvent);
    }
}
