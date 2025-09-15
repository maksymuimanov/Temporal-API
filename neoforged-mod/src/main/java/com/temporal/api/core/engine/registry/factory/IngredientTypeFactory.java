package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.neoforged.neoforge.common.crafting.IngredientType;

public class IngredientTypeFactory extends AbstractObjectFactory<IngredientType<?>> {
    public IngredientTypeFactory() {
        this(InjectionPool.getFromInstance("$IngredientTypes"));
    }

    public IngredientTypeFactory(TemporalRegister<IngredientType<?>> register) {
        super(register);
    }
}
