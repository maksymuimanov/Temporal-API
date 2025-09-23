package com.temporal.api.core.engine.metadata.strategy.field.data;

import com.temporal.api.core.engine.event.data.jukebox.ApiJukeboxSongProvider;
import com.temporal.api.core.engine.event.data.jukebox.JukeboxSongDescription;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.GenerateJukeboxSong;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.JukeboxSong;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateJukeboxSongStrategy implements FieldAnnotationStrategy<GenerateJukeboxSong> {
    @Override
    public void execute(Field field, Object object, GenerateJukeboxSong annotation) throws Exception {
        ResourceKey<JukeboxSong> jukeboxSong = ReflectionUtils.getFieldValue(field, object);
        JukeboxSongDescription description = new JukeboxSongDescription(jukeboxSong, annotation.soundEvent(), annotation.lengthInSeconds(), annotation.comparatorOutput());
        ApiJukeboxSongProvider.SONGS.add(description);
    }

    @Override
    public Class<GenerateJukeboxSong> getAnnotationClass() {
        return GenerateJukeboxSong.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
