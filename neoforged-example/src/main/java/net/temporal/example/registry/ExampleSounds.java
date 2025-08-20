package net.temporal.example.registry;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.engine.io.metadata.annotation.data.language.EnglishTranslation;
import com.temporal.api.core.engine.io.metadata.annotation.data.other.SoundDescription;
import com.temporal.api.core.engine.io.metadata.annotation.injection.Injected;
import com.temporal.api.core.engine.io.metadata.annotation.injection.Registry;
import com.temporal.api.core.registry.factory.common.SoundEventFactory;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;

@Injected(false)
public final class ExampleSounds {
    @Registry
    private static final SoundEventFactory SOUND_EVENT_FACTORY = InjectionPool.getFromInstance(SoundEventFactory.class);

    @EnglishTranslation("Example Sound")
    @SoundDescription(@SoundDescription.Sound(fileName = "example_sound"))
    public static final Holder<SoundEvent> EXAMPLE_SOUND = SOUND_EVENT_FACTORY.create("example_sound");
}
