package com.temporal.api.core.engine.event.data.damage;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.damagesource.DamageType;

public interface DamageTypeProvider {
    void registerDamageTypes(BootstrapContext<DamageType> context);
}
