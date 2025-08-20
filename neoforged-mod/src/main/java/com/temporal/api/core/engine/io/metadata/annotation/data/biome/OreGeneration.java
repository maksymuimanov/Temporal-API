package com.temporal.api.core.engine.io.metadata.annotation.data.biome;

import com.temporal.api.core.engine.io.metadata.constant.OrePlacementShape;
import com.temporal.api.core.engine.io.metadata.constant.OreRarity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface OreGeneration {
    String blockId();
    String[] replaceableBlocks();
    int size() default 1;
    OreRarity rarity() default OreRarity.COMMON;
    int count() default 1;
    OrePlacementShape shape() default OrePlacementShape.UNIFORM;
    int from();
    int to();
    String biomeTag() default "minecraft:is_overworld";
    Class<?> biomeTagContainer() default Object.class;
}
