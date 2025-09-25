package com.temporal.api.core.engine.event.data.banner;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.BannerPattern;

public record BannerPatternDescription(ResourceKey<BannerPattern> pattern) {
}
