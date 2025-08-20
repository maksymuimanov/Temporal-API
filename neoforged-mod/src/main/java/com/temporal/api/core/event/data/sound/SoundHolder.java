package com.temporal.api.core.event.data.sound;

import net.neoforged.neoforge.common.data.SoundDefinition;

public record SoundHolder(String id, SoundDefinition.SoundType type, double volume, double pitch, int weight, int attenuationDistance, boolean stream, boolean preload) {
}
