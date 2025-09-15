package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicateType;

public class BlockPredicateTypeFactory extends AbstractObjectFactory<BlockPredicateType<?>> {
    public BlockPredicateTypeFactory() {
        this(InjectionPool.getFromInstance("$BlockPredicateTypes"));
    }

    public BlockPredicateTypeFactory(TemporalRegister<BlockPredicateType<?>> register) {
        super(register);
    }
}
