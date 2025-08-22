package net.temporal.example.registry;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.engine.io.metadata.annotation.data.GenerateSound;
import com.temporal.api.core.engine.io.metadata.annotation.data.language.TranslateEnglish;
import com.temporal.api.core.engine.io.metadata.annotation.injection.Injected;
import com.temporal.api.core.engine.io.metadata.annotation.injection.RegisterFactory;
import com.temporal.api.core.registry.factory.common.SoundEventFactory;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;

@Injected
public final class ExampleSounds {
    @RegisterFactory
    private static final SoundEventFactory SOUND_EVENT_FACTORY = InjectionPool.getFromInstance(SoundEventFactory.class);

    @TranslateEnglish("Example Sound")
    @GenerateSound(@GenerateSound.Sound(fileName = "example_sound"))
    public static final Holder<SoundEvent> EXAMPLE_SOUND = SOUND_EVENT_FACTORY.create("example_sound");
}
