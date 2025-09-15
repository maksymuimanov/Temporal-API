package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.feature.rootplacers.RootPlacerType;

public class RootPlacerTypeFactory extends AbstractObjectFactory<RootPlacerType<?>> {
    public RootPlacerTypeFactory() {
        this(InjectionPool.getFromInstance("$RootPlacerTypes"));
    }

    public RootPlacerTypeFactory(TemporalRegister<RootPlacerType<?>> register) {
        super(register);
    }
}
