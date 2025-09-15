package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.util.valueproviders.FloatProviderType;

public class FloatProviderTypeFactory extends AbstractObjectFactory<FloatProviderType<?>> {
    public FloatProviderTypeFactory() {
        this(InjectionPool.getFromInstance("$FloatProviderTypes"));
    }

    public FloatProviderTypeFactory(TemporalRegister<FloatProviderType<?>> register) {
        super(register);
    }
}
