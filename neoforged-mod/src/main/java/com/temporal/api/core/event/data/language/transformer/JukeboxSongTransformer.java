package com.temporal.api.core.event.data.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.JukeboxSong;

public class JukeboxSongTransformer implements KeyTransformer<ResourceKey<JukeboxSong>> {
    @Override
    public String transform(ResourceKey<JukeboxSong> jukeboxSong) {
        return this.transformResourceKey("jukebox_song", jukeboxSong);
    }
}
