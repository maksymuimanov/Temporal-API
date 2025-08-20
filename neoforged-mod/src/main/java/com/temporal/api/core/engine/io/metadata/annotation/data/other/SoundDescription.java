package com.temporal.api.core.engine.io.metadata.annotation.data.other;

import net.neoforged.neoforge.common.data.SoundDefinition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SoundDescription {
    Sound[] value();
    boolean replace() default false;

    @interface Sound {
        String fileName();
        SoundDefinition.SoundType type() default SoundDefinition.SoundType.SOUND;
        double volume() default 1.0D;
        double pitch() default 1.0D;
        int weight() default 1;
        int attenuationDistance() default 16;
        boolean stream() default false;
        boolean preload() default false;
    }
}
