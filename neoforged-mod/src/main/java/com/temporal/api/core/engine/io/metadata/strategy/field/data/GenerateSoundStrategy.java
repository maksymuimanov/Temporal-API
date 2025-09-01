package com.temporal.api.core.engine.io.metadata.strategy.field.data;

import com.temporal.api.core.engine.io.metadata.annotation.data.GenerateSound;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.sound.ApiSoundProvider;
import com.temporal.api.core.event.data.sound.SoundDescription;
import com.temporal.api.core.event.data.sound.SoundHolder;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

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
