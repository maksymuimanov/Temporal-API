package com.temporal.api.core.registry.factory;

import com.temporal.api.core.engine.io.context.InjectionPool;
import net.minecraft.advancements.CriterionTrigger;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TriggerFactory extends AbstractObjectFactory<CriterionTrigger<?>> {
    public TriggerFactory() {
        this(InjectionPool.getFromInstance("$TriggerTypes"));
    }

    public TriggerFactory(DeferredRegister<CriterionTrigger<?>> triggerTypes) {
        super(triggerTypes);
    }
}
