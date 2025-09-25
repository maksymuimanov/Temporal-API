package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.advancements.CriterionTrigger;

public class TriggerTypeFactory extends AbstractObjectFactory<CriterionTrigger<?>> {
    public TriggerTypeFactory() {
        this(InjectionPool.getFromInstance("$TriggerTypes"));
    }

    public TriggerTypeFactory(TemporalRegister<CriterionTrigger<?>> register) {
        super(register);
    }
}
