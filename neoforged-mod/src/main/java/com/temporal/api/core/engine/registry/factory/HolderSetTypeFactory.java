package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.neoforged.neoforge.registries.holdersets.HolderSetType;

public class HolderSetTypeFactory extends AbstractObjectFactory<HolderSetType> {
    public HolderSetTypeFactory() {
        this(InjectionPool.getFromInstance("$HolderSetTypes"));
    }

    public HolderSetTypeFactory(TemporalRegister<HolderSetType> register) {
        super(register);
    }
}
