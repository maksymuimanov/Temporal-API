package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

public class StructureProcessorFactory extends AbstractObjectFactory<StructureProcessorType<?>> {
    public StructureProcessorFactory() {
        this(InjectionPool.getFromInstance("$StructureProcessors"));
    }

    public StructureProcessorFactory(TemporalRegister<StructureProcessorType<?>> register) {
        super(register);
    }
}
