package com.temporal.api.core.registry.factory.common;

import com.temporal.api.core.engine.io.context.InjectionPool;
import net.minecraft.advancements.CriterionTrigger;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TriggerFactory extends AbstractObjectFactory<CriterionTrigger<?>> {
    private final DeferredRegister<CriterionTrigger<?>> triggerTypes;

    public TriggerFactory() {
        this(InjectionPool.getFromInstance("$TriggerTypes"));
    }

    public TriggerFactory(DeferredRegister<CriterionTrigger<?>> triggerTypes) {
        this.triggerTypes = triggerTypes;
    }

    @Override
    public DeferredRegister<CriterionTrigger<?>> getRegistry() {
        return triggerTypes;
    }
}
