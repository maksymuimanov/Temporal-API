package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.neoforged.neoforge.common.conditions.ICondition;

public class ConditionCodecFactory extends AbstractObjectFactory<MapCodec<? extends ICondition>> {
    public ConditionCodecFactory() {
        this(InjectionPool.getFromInstance("$ConditionCodecs"));
    }

    public ConditionCodecFactory(TemporalRegister<MapCodec<? extends ICondition>> register) {
        super(register);
    }
}
