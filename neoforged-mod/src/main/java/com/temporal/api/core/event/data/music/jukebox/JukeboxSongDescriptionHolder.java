package com.temporal.api.core.event.data.music.jukebox;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.JukeboxSong;

public record JukeboxSongDescriptionHolder(ResourceKey<JukeboxSong> song, String soundEvent, float lengthInSeconds, int comparatorOutput) {
}
