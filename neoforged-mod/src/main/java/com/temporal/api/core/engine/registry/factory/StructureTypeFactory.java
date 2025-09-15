package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.structure.StructureType;

public class StructureTypeFactory extends AbstractObjectFactory<StructureType<?>> {
    public StructureTypeFactory() {
        this(InjectionPool.getFromInstance("$StructureTypes"));
    }

    public StructureTypeFactory(TemporalRegister<StructureType<?>> register) {
        super(register);
    }
}
