package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.heightproviders.HeightProviderType;

public class HeightProviderTypeFactory extends AbstractObjectFactory<HeightProviderType<?>> {
    public HeightProviderTypeFactory() {
        this(InjectionPool.getFromInstance("$HeightProviderTypes"));
    }

    public HeightProviderTypeFactory(TemporalRegister<HeightProviderType<?>> register) {
        super(register);
    }
}
