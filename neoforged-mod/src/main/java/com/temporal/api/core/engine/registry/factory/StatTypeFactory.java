package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.stats.StatType;

public class StatTypeFactory extends AbstractObjectFactory<StatType<?>> {
    public StatTypeFactory() {
        this(InjectionPool.getFromInstance("$StatTypes"));
    }

    public StatTypeFactory(TemporalRegister<StatType<?>> register) {
        super(register);
    }
}
