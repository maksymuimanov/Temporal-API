package com.temporal.api.core.engine.io.metadata.annotation.data.biome;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenerateGrass {
    Configuration configuration();

    Placement placement() default @Placement;

    BiomeModifier biomeModifier() default @BiomeModifier;

    @interface Configuration {
        String blockId();
        int tries() default 32;
    }

    @interface Placement {
        int count() default 5;
    }

    @interface BiomeModifier {
        String biomeTag() default "minecraft:is_overworld";
        Class<?> biomeTagContainer() default Object.class;
    }
}
