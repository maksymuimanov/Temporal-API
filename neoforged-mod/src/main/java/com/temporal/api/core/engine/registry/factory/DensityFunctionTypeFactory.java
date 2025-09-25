package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.DensityFunction;

public class DensityFunctionTypeFactory extends AbstractObjectFactory<MapCodec<? extends DensityFunction>> {
    public DensityFunctionTypeFactory() {
        this(InjectionPool.getFromInstance("$DensityFunctionTypes"));
    }

    public DensityFunctionTypeFactory(TemporalRegister<MapCodec<? extends DensityFunction>> register) {
        super(register);
    }
}
