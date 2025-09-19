package com.temporal.api.core.engine.event.data.cat;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.entity.animal.CatVariant;

public interface CatVariantProvider {
    void addVariant(BootstrapContext<CatVariant> context);
}
