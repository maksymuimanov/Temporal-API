package com.temporal.api.core.engine.event.data.pot;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;

public interface DecoratedPotPatternProvider {
    void addVariant(BootstrapContext<DecoratedPotPattern> context);
}
