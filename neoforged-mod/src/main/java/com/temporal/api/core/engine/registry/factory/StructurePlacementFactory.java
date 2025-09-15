package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacementType;

public class StructurePlacementFactory extends AbstractObjectFactory<StructurePlacementType<?>> {
    public StructurePlacementFactory() {
        this(InjectionPool.getFromInstance("$StructurePlacements"));
    }

    public StructurePlacementFactory(TemporalRegister<StructurePlacementType<?>> register) {
        super(register);
    }
}
