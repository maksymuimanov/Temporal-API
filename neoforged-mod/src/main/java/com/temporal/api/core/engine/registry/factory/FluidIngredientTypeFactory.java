package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.neoforged.neoforge.fluids.crafting.FluidIngredientType;

public class FluidIngredientTypeFactory extends AbstractObjectFactory<FluidIngredientType<?>> {
    public FluidIngredientTypeFactory() {
        this(InjectionPool.getFromInstance("$FluidIngredientTypes"));
    }

    public FluidIngredientTypeFactory(TemporalRegister<FluidIngredientType<?>> register) {
        super(register);
    }
}
