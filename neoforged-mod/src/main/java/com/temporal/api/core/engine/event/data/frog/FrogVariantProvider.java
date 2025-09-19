package com.temporal.api.core.engine.event.data.frog;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.entity.animal.FrogVariant;

public interface FrogVariantProvider {
    void addVariant(BootstrapContext<FrogVariant> context);
}
