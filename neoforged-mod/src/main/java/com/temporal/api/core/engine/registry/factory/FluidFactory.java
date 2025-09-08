package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.material.Fluid;

public class FluidFactory extends AbstractObjectFactory<Fluid> {
    public FluidFactory() {
        this(InjectionPool.getFromInstance("$Fluids"));
    }

    public FluidFactory(TemporalRegister<Fluid> fluids) {
        super(fluids);
    }
}