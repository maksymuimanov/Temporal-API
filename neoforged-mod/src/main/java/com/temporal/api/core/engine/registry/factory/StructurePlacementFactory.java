package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacementType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class StructurePlacementFactory extends AbstractObjectFactory<StructurePlacementType<?>> {
    public StructurePlacementFactory() {
        this(InjectionPool.getFromInstance("$StructurePlacements"));
    }

    public StructurePlacementFactory(TemporalRegister<StructurePlacementType<?>> register) {
        super(register);
    }

    public <T extends StructurePlacement> DeferredHolder<StructurePlacementType<?>, StructurePlacementType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> () -> mapCodec);
    }
}
