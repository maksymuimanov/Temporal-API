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
    public static final Map<SoundHolder, List<SoundDescription>> SOUNDS = new TemporalMap<>();

    public ApiSoundProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, IOLayer.NEO_MOD.getModId(), existingFileHelper);
    }

    @Override
    public void registerSounds() {
        final String modId = IOLayer.NEO_MOD.getModId();
        SOUNDS.forEach((holder, descriptions) -> {
            SoundDefinition soundDefinition = definition();
            descriptions.forEach(soundDescription -> soundDefinition.with(
                    sound(modId + ":" + soundDescription.id(), soundDescription.type())
                            .volume(soundDescription.volume())
                            .pitch(soundDescription.pitch())
                            .weight(soundDescription.weight())
                            .attenuationDistance(soundDescription.attenuationDistance())
                            .stream(soundDescription.stream())
                            .preload(soundDescription.preload())));
            add(holder.sound().value(), soundDefinition.subtitle("sound." + modId + "." + Objects.requireNonNull(holder.sound().getKey()).location().getPath())
                    .replace(holder.replace()));
        });
    }
}
