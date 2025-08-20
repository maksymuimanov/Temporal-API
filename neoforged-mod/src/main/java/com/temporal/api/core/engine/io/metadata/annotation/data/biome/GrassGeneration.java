package com.temporal.api.core.engine.io.metadata.annotation.data.biome;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GrassGeneration {
    String blockId();
    int tries() default 32;
    int count() default 5;
    String biomeTag() default "minecraft:is_overworld";
    Class<?> biomeTagContainer() default Object.class;
}
