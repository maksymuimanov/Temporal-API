package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.util.valueproviders.IntProviderType;

public class IntProviderTypeFactory extends AbstractObjectFactory<IntProviderType<?>> {
    public IntProviderTypeFactory() {
        this(InjectionPool.getFromInstance("$IntProviderTypes"));
    }

    public IntProviderTypeFactory(TemporalRegister<IntProviderType<?>> register) {
        super(register);
    }
}
