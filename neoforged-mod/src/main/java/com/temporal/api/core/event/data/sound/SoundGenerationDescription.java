package com.temporal.api.core.event.data.sound;

import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;

public record SoundGenerationDescription(Holder<SoundEvent> sound, boolean replace) {
}
