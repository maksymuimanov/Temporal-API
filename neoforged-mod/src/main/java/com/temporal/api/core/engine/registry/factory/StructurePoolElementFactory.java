package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElementType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class StructurePoolElementFactory extends AbstractObjectFactory<StructurePoolElementType<?>> {
    public StructurePoolElementFactory() {
        this(InjectionPool.getFromInstance("$StructurePoolElements"));
    }

    public StructurePoolElementFactory(TemporalRegister<StructurePoolElementType<?>> register) {
        super(register);
    }

    public <T extends StructurePoolElement> DeferredHolder<StructurePoolElementType<?>, StructurePoolElementType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> () -> mapCodec);
    }
}
