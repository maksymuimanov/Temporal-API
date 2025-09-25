package com.temporal.api.core.engine.event.data.jukebox;

import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.engine.event.data.language.transformer.JukeboxSongTransformer;
import com.temporal.api.core.util.RegistryUtils;
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
    public static final Queue<JukeboxSongDescription> SONGS = new TemporalQueue<>();

    @Override
    public void addSong(BootstrapContext<JukeboxSong> context) {
        SONGS.forEach(description -> {
            ResourceKey<JukeboxSong> song = description.song();
            MutableComponent translationId = Component.translatable(Util.makeDescriptionId(JukeboxSongTransformer.PREFIX, song.location()));
            SoundEvent soundEvent = RegistryUtils.getSoundEvent(description.soundEvent());
            context.register(song, new JukeboxSong(Holder.direct(soundEvent), translationId, description.lengthInSeconds(), description.comparatorOutput()));
        });
    }

    public static void bootstrap(BootstrapContext<JukeboxSong> context) {
        JukeboxSongProvider provider = new ApiJukeboxSongProvider();
        provider.addSong(context);
    }
}
