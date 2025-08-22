package com.temporal.api.core.engine.io.metadata.strategy.field.data;

import com.temporal.api.core.engine.io.metadata.annotation.data.GenerateJukeboxSong;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.music.jukebox.ApiJukeboxSongProvider;
import com.temporal.api.core.event.data.music.jukebox.JukeboxSongDescriptionHolder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.JukeboxSong;

import java.lang.reflect.Field;

public class GenerateJukeboxSongStrategy implements FieldAnnotationStrategy<GenerateJukeboxSong> {
    @Override
    public void execute(Field field, Object object, GenerateJukeboxSong annotation) throws Exception {
        ResourceKey<JukeboxSong> jukeboxSong = (ResourceKey<JukeboxSong>) field.get(object);
        JukeboxSongDescriptionHolder descriptionHolder = new JukeboxSongDescriptionHolder(jukeboxSong, annotation.soundEvent(), annotation.lengthInSeconds(), annotation.comparatorOutput());
        ApiJukeboxSongProvider.SONGS.add(descriptionHolder);
    }

    @Override
    public Class<? extends GenerateJukeboxSong> getAnnotationClass() {
        return GenerateJukeboxSong.class;
    }
}
