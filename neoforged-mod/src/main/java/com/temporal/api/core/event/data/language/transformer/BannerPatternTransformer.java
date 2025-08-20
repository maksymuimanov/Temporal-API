package com.temporal.api.core.event.data.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.BannerPattern;

public class BannerPatternTransformer implements KeyTransformer<ResourceKey<BannerPattern>> {
    @Override
    public String transform(ResourceKey<BannerPattern> bannerPattern) {
        return "block.minecraft.banner." + bannerPattern.location().toShortLanguageKey();
    }
}
