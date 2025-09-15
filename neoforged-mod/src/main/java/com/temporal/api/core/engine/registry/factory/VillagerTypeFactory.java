package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.entity.npc.VillagerType;

public class VillagerTypeFactory extends AbstractObjectFactory<VillagerType> {
    public VillagerTypeFactory() {
        this(InjectionPool.getFromInstance("$VillagerTypes"));
    }

    public VillagerTypeFactory(TemporalRegister<VillagerType> register) {
        super(register);
    }
}
