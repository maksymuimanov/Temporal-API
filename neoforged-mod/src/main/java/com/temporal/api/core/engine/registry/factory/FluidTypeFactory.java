package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class FluidTypeFactory extends AbstractObjectFactory<FluidType> {
    public FluidTypeFactory() {
        this(InjectionPool.getFromInstance("$FluidTypes"));
    }

    public FluidTypeFactory(TemporalRegister<FluidType> fluidTypes) {
        super(fluidTypes);
    }

    public DeferredHolder<FluidType, FluidType> create(String name, FluidType.Properties properties) {
        return this.create(name, () -> new FluidType(properties));
    }
}