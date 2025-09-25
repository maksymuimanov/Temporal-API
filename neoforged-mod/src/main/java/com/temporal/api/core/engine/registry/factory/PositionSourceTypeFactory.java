package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.gameevent.PositionSourceType;

public class PositionSourceTypeFactory extends AbstractObjectFactory<PositionSourceType<?>> {
    public PositionSourceTypeFactory() {
        this(InjectionPool.getFromInstance("$PositionSourceTypes"));
    }

    public PositionSourceTypeFactory(TemporalRegister<PositionSourceType<?>> register) {
        super(register);
    }
}
