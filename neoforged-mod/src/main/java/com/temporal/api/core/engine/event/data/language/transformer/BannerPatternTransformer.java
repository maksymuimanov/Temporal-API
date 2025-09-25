package com.temporal.api.core.engine.event.data.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.BannerPattern;

public class BannerPatternTransformer implements KeyTransformer<ResourceKey<BannerPattern>> {
    public static final String PREFIX = "block.minecraft.banner.";

    @Override
    public String transform(ResourceKey<BannerPattern> bannerPattern) {
        return PREFIX + bannerPattern.location().toShortLanguageKey();
    }
}
