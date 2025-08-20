package com.temporal.api.core.event.data.music.jukebox;

import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.util.other.RegistryUtils;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;

import java.util.Queue;

public class ApiJukeboxSongProvider implements JukeboxSongProvider {
    public static final Queue<JukeboxSongDescriptionHolder> SONGS = new TemporalQueue<>();

    @Override
    public void registerSong(BootstrapContext<JukeboxSong> context) {
        SONGS.forEach(description -> {
            ResourceKey<JukeboxSong> song = description.song();
            MutableComponent translationId = Component.translatable(Util.makeDescriptionId("jukebox_song", song.location()));
            SoundEvent soundEvent = RegistryUtils.getSoundEventById(description.soundEvent());
            context.register(song, new JukeboxSong(Holder.direct(soundEvent), translationId, description.lengthInSeconds(), description.comparatorOutput()));
        });
    }

    public static void bootstrap(BootstrapContext<JukeboxSong> context) {
        JukeboxSongProvider provider = new ApiJukeboxSongProvider();
        provider.registerSong(context);
    }
}
