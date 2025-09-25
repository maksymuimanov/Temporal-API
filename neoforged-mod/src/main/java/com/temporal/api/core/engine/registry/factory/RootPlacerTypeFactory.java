package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.feature.rootplacers.RootPlacer;
import net.minecraft.world.level.levelgen.feature.rootplacers.RootPlacerType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class RootPlacerTypeFactory extends AbstractObjectFactory<RootPlacerType<?>> {
    public RootPlacerTypeFactory() {
        this(InjectionPool.getFromInstance("$RootPlacerTypes"));
    }

    public RootPlacerTypeFactory(TemporalRegister<RootPlacerType<?>> register) {
        super(register);
    }

    public <T extends RootPlacer> DeferredHolder<RootPlacerType<?>, RootPlacerType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> new RootPlacerType<>(mapCodec));
    }
}
