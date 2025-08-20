package com.temporal.api.core.event.data.sound;

import com.temporal.api.core.collection.TemporalMap;
import com.temporal.api.core.engine.io.IOLayer;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ApiSoundProvider extends SoundDefinitionsProvider {
    public static final Map<SoundGenerationDescription, List<SoundHolder>> SOUNDS = new TemporalMap<>();

    public ApiSoundProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, IOLayer.NEO_MOD.getModId(), existingFileHelper);
    }

    @Override
    public void registerSounds() {
        final String modId = IOLayer.NEO_MOD.getModId();
        SOUNDS.forEach((description, soundHolders) -> {
            SoundDefinition soundDefinition = definition();
            soundHolders.forEach(soundHolder -> soundDefinition.with(
                    sound(modId + ":" + soundHolder.id(), soundHolder.type())
                            .volume(soundHolder.volume())
                            .pitch(soundHolder.pitch())
                            .weight(soundHolder.weight())
                            .attenuationDistance(soundHolder.attenuationDistance())
                            .stream(soundHolder.stream())
                            .preload(soundHolder.preload())));
            add(description.sound().value(), soundDefinition.subtitle("sound." + modId + "." + Objects.requireNonNull(description.sound().getKey()).location().getPath())
                    .replace(description.replace()));
        });
    }
}
