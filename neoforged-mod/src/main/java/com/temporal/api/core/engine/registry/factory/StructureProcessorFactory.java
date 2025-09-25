package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class StructureProcessorFactory extends AbstractObjectFactory<StructureProcessorType<?>> {
    public StructureProcessorFactory() {
        this(InjectionPool.getFromInstance("$StructureProcessors"));
    }

    public StructureProcessorFactory(TemporalRegister<StructureProcessorType<?>> register) {
        super(register);
    }

    public <T extends StructureProcessor> DeferredHolder<StructureProcessorType<?>, StructureProcessorType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> () -> mapCodec);
    }
}
