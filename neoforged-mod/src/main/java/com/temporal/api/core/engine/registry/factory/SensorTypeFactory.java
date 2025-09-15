package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.entity.ai.sensing.SensorType;

public class SensorTypeFactory extends AbstractObjectFactory<SensorType<?>> {
    public SensorTypeFactory() {
        this(InjectionPool.getFromInstance("$SensorTypes"));
    }

    public SensorTypeFactory(TemporalRegister<SensorType<?>> register) {
        super(register);
    }
}
