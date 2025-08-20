package com.temporal.api.core.event.data.trim.pattern;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.armortrim.TrimPattern;

public interface TrimPatternProvider {
    void registerTrimPatterns(BootstrapContext<TrimPattern> context);
}
