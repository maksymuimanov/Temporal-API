package com.temporal.api.core.engine.event.data.music.jukebox;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.JukeboxSong;

public interface JukeboxSongProvider {
    void registerSong(BootstrapContext<JukeboxSong> context);
}
