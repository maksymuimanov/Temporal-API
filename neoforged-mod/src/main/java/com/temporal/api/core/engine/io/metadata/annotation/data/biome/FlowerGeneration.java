package com.temporal.api.core.engine.io.metadata.annotation.data.biome;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FlowerGeneration {
    String blockId();
    int tries() default 64;
    int xzSpread() default 6;
    int ySpread() default 2;
    long noiseSeed() default 0;
    float noiseScale() default 0.005F;
    float noiseThreshold() default -0.8F;
    float noiseHighChance() default 0.33333334F;
    int firstOctave() default 0;
    double[] amplitudes() default {1.0D};
    String[] lowStateFlowers();
    String[] highStateFlowers();
    int chance() default 32;
    float noiseLevel() default -0.8F;
    int belowNoise() default 15;
    int aboveNoise() default 4;
    String biomeTag() default "minecraft:is_overworld";
    Class<?> biomeTagContainer() default Object.class;
}
