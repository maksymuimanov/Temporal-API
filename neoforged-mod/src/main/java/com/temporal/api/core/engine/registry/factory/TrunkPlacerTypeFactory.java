package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class TrunkPlacerTypeFactory extends AbstractObjectFactory<TrunkPlacerType<?>> {
    public TrunkPlacerTypeFactory() {
        this(InjectionPool.getFromInstance("$TrunkPlacerTypes"));
    }

    public TrunkPlacerTypeFactory(TemporalRegister<TrunkPlacerType<?>> trunkPlacerTypes) {
        super(trunkPlacerTypes);
    }

    public <T extends TrunkPlacer> DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<T>> create(String name, MapCodec<T> codec) {
        return this.create(name, () -> new TrunkPlacerType<>(codec));
    }
}