package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class MaterialConditionFactory extends AbstractObjectFactory<MapCodec<? extends SurfaceRules.ConditionSource>> {
    public MaterialConditionFactory() {
        this(InjectionPool.getFromInstance("$MaterialConditions"));
    }

    public MaterialConditionFactory(TemporalRegister<MapCodec<? extends SurfaceRules.ConditionSource>> register) {
        super(register);
    }
}
