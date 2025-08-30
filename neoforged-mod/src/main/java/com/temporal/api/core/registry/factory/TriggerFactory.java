package com.temporal.api.core.registry.factory;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.TemporalRegister;
import net.minecraft.advancements.CriterionTrigger;

public class TriggerFactory extends AbstractObjectFactory<CriterionTrigger<?>> {
    public TriggerFactory() {
        this(InjectionPool.getFromInstance("$TriggerTypes"));
    }

    public TriggerFactory(TemporalRegister<CriterionTrigger<?>> triggerTypes) {
        super(triggerTypes);
    }
}
