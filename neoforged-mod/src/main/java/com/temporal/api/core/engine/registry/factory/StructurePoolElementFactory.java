package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElementType;

public class StructurePoolElementFactory extends AbstractObjectFactory<StructurePoolElementType<?>> {
    public StructurePoolElementFactory() {
        this(InjectionPool.getFromInstance("$StructurePoolElements"));
    }

    public StructurePoolElementFactory(TemporalRegister<StructurePoolElementType<?>> register) {
        super(register);
    }
}
