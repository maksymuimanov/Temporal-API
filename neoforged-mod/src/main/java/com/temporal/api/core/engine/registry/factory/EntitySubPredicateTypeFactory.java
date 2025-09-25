package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.advancements.critereon.EntitySubPredicate;

public class EntitySubPredicateTypeFactory extends AbstractObjectFactory<MapCodec<? extends EntitySubPredicate>> {
    public EntitySubPredicateTypeFactory() {
        this(InjectionPool.getFromInstance("$EntitySubPredicateTypes"));
    }

    public EntitySubPredicateTypeFactory(TemporalRegister<MapCodec<? extends EntitySubPredicate>> register) {
        super(register);
    }
}
