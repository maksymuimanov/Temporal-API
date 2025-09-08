package com.temporal.api.core.engine.metadata.strategy.field.data;

import com.temporal.api.core.engine.event.data.jukebox.ApiJukeboxSongProvider;
import com.temporal.api.core.engine.event.data.jukebox.JukeboxSongDescription;
import com.temporal.api.core.engine.metadata.annotation.data.GenerateJukeboxSong;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.JukeboxSong;

import java.lang.reflect.Field;

public class GenerateJukeboxSongStrategy implements FieldAnnotationStrategy<GenerateJukeboxSong> {
    @Override
    public void execute(Field field, Object object, GenerateJukeboxSong annotation) throws Exception {
        ResourceKey<JukeboxSong> jukeboxSong = (ResourceKey<JukeboxSong>) field.get(object);
        JukeboxSongDescription description = new JukeboxSongDescription(jukeboxSong, annotation.soundEvent(), annotation.lengthInSeconds(), annotation.comparatorOutput());
        ApiJukeboxSongProvider.SONGS.add(description);
    }

    @Override
    public Class<? extends GenerateJukeboxSong> getAnnotationClass() {
        return GenerateJukeboxSong.class;
    }
}
