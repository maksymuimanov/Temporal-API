package com.temporal.api.core.engine.io.metadata.annotation.data.biome;

import com.temporal.api.core.engine.io.metadata.constant.OrePlacementShape;
import com.temporal.api.core.engine.io.metadata.constant.OreRarity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenerateOre {
    Configuration configuration();

    Placement placement();

    BiomeModifier biomeModifier() default @BiomeModifier;

    @interface Configuration {
        String blockId();
        String[] replaceableBlocksIds() default {};
        String replaceableBlocksTag() default "";
        Class<?> blockTagContainer() default Object.class;
        int size() default 1;
        float discardChanceOnAirExposure() default 0.0F;
    }

    @interface Placement {
        OreRarity rarity() default OreRarity.COMMON;
        int count() default 1;
        OrePlacementShape shape() default OrePlacementShape.UNIFORM;
        int from();
        int to();
    }

    @interface BiomeModifier {
        String biomeTag() default "minecraft:is_overworld";
        Class<?> biomeTagContainer() default Object.class;
    }
}
