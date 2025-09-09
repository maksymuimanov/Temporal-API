package net.temporal.example.sound;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.metadata.annotation.data.GenerateSound;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateAmericanEnglish;
import com.temporal.api.core.engine.registry.factory.SoundEventFactory;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;

public final class ExampleSounds {
    private static final SoundEventFactory SOUND_EVENT_FACTORY = InjectionPool.getFromInstance(SoundEventFactory.class);

    @TranslateAmericanEnglish("Example Sound")
    @GenerateSound(@GenerateSound.Sound(fileName = "example_sound"))
    public static final Holder<SoundEvent> EXAMPLE_SOUND = SOUND_EVENT_FACTORY.create("example_sound");

    @TranslateAmericanEnglish("Example Jukebox Song Sound")
    @GenerateSound(@GenerateSound.Sound(fileName = "example_jukebox_song_sound"))
    public static final Holder<SoundEvent> EXAMPLE_JUKEBOX_SONG_SOUND = SOUND_EVENT_FACTORY.create("example_jukebox_song_sound");
}
