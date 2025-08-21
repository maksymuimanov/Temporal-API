package com.temporal.api.core.engine.io.metadata.annotation.data.biome;

import com.temporal.api.core.engine.io.metadata.constant.TreeFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenerateTree {
    Configuration configuration();

    Placement placement();

    BiomeModifier biomeModifier() default @BiomeModifier;

    @interface Configuration {
        String logBlockId();
        String leavesBlockId();
        String rootBlockId() default "minecraft:grass_block";
        Trunk trunk();
        Foliage foliage();
        FeatureSize featureSize();
        boolean ignoreVines() default true;
    }

    @interface Placement {
        String saplingBlockId();
        int baseValue();
        int chance();
        int addedAmount();
    }

    @interface BiomeModifier {
        String biomeTag() default "minecraft:is_overworld";
        Class<?> biomeTagContainer() default Object.class;
    }

    @interface Trunk {
        Class<? extends TrunkPlacer> trunkPlacerClass() default ForkingTrunkPlacer.class;
        int baseHeight();
        int heightRandA();
        int heightRandB();
    }

    @interface Foliage {
        Class<? extends FoliagePlacer> foliagePlacerClass() default BlobFoliagePlacer.class;
        int radius();
        int offset();
        int height();
    }

    @interface FeatureSize {
        TreeFeatureSize type() default TreeFeatureSize.TWO_LAYERED;
        int limit();
        int upperLimit() default 0;
        int lowerSize();
        int middleSize() default 0;
        int upperSize();
        int minClippedHeight() default 0;
    }
}
