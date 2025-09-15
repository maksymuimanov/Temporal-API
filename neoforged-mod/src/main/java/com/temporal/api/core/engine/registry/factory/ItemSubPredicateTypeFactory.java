package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.advancements.critereon.ItemSubPredicate;

public class ItemSubPredicateTypeFactory extends AbstractObjectFactory<ItemSubPredicate.Type<?>> {
    public ItemSubPredicateTypeFactory() {
        this(InjectionPool.getFromInstance("$ItemSubPredicateTypes"));
    }

    public ItemSubPredicateTypeFactory(TemporalRegister<ItemSubPredicate.Type<?>> register) {
        super(register);
    }
}
