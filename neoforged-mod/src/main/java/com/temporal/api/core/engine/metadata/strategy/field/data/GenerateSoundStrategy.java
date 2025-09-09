package com.temporal.api.core.engine.metadata.strategy.field.data;

import com.temporal.api.core.engine.event.data.sound.ApiSoundProvider;
import com.temporal.api.core.engine.event.data.sound.SoundDescription;
import com.temporal.api.core.engine.event.data.sound.SoundHolder;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.GenerateSound;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateSoundStrategy implements FieldAnnotationStrategy<GenerateSound> {
    @Override
    public void execute(Field field, Object object, GenerateSound annotation) throws Exception {
        Holder<SoundEvent> soundEvent = (Holder<SoundEvent>) field.get(object);
        SoundHolder description = new SoundHolder(soundEvent, annotation.replace());
        List<SoundDescription> soundDescriptions = Arrays.stream(annotation.value())
                .map(sound -> new SoundDescription(sound.fileName(), sound.type(),
                        sound.volume(), sound.pitch(),
                        sound.weight(), sound.attenuationDistance(),
                        sound.stream(), sound.preload()))
                .toList();
        ApiSoundProvider.SOUNDS.put(description, soundDescriptions);
    }

    @Override
    public Class<? extends GenerateSound> getAnnotationClass() {
        return GenerateSound.class;
    }
}
