package com.temporal.api.core.engine.event.data.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.JukeboxSong;

public class JukeboxSongTransformer implements KeyTransformer<ResourceKey<JukeboxSong>> {
    public static final String PREFIX = "jukebox_song";

    @Override
    public String transform(ResourceKey<JukeboxSong> jukeboxSong) {
        return this.transformResourceKey(PREFIX, jukeboxSong);
    }
}
