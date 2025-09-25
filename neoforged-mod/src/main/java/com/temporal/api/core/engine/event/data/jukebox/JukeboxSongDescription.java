package com.temporal.api.core.engine.event.data.jukebox;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.JukeboxSong;

public record JukeboxSongDescription(ResourceKey<JukeboxSong> song, String soundEvent, float lengthInSeconds, int comparatorOutput) {
}
