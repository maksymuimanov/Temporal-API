package com.temporal.api.core.event.data.banner;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.block.entity.BannerPattern;

public interface BannerPatternProvider {
    void addVariant(BootstrapContext<BannerPattern> context);
}
