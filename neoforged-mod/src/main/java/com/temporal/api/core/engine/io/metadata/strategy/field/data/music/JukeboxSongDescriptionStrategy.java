package com.temporal.api.core.engine.io.metadata.strategy.field.data.music;

import com.temporal.api.core.engine.io.metadata.annotation.data.GenerationJukeboxSong;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.music.jukebox.ApiJukeboxSongProvider;
import com.temporal.api.core.event.data.music.jukebox.JukeboxSongDescriptionHolder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.JukeboxSong;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class JukeboxSongDescriptionStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        GenerationJukeboxSong annotation = field.getDeclaredAnnotation(GenerationJukeboxSong.class);
        ResourceKey<JukeboxSong> jukeboxSong = (ResourceKey<JukeboxSong>) field.get(object);
        JukeboxSongDescriptionHolder descriptionHolder = new JukeboxSongDescriptionHolder(jukeboxSong, annotation.soundEvent(), annotation.lengthInSeconds(), annotation.comparatorOutput());
        ApiJukeboxSongProvider.SONGS.add(descriptionHolder);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return GenerationJukeboxSong.class;
    }
}
