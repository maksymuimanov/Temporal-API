package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class StructureTypeFactory extends AbstractObjectFactory<StructureType<?>> {
    public StructureTypeFactory() {
        this(InjectionPool.getFromInstance("$StructureTypes"));
    }

    public StructureTypeFactory(TemporalRegister<StructureType<?>> register) {
        super(register);
    }

    public <T extends Structure> DeferredHolder<StructureType<?>, StructureType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> () -> mapCodec);
    }
}
