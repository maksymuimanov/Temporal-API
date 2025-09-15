package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;

public class MemoryModuleTypeFactory extends AbstractObjectFactory<MemoryModuleType<?>> {
    public MemoryModuleTypeFactory() {
        this(InjectionPool.getFromInstance("$MemoryModuleTypes"));
    }

    public MemoryModuleTypeFactory(TemporalRegister<MemoryModuleType<?>> register) {
        super(register);
    }
}
