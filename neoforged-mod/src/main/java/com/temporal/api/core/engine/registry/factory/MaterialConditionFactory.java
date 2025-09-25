package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.neoforged.neoforge.registries.DeferredHolder;

public class MaterialConditionFactory extends AbstractObjectFactory<MapCodec<? extends SurfaceRules.ConditionSource>> {
    public MaterialConditionFactory() {
        this(InjectionPool.getFromInstance("$MaterialConditions"));
    }

    public MaterialConditionFactory(TemporalRegister<MapCodec<? extends SurfaceRules.ConditionSource>> register) {
        super(register);
    }

    public <T extends SurfaceRules.ConditionSource> DeferredHolder<MapCodec<? extends SurfaceRules.ConditionSource>, MapCodec<? extends T>> create(String name, KeyDispatchDataCodec<? extends T> codec) {
        return this.create(name, codec::codec);
    }
}
