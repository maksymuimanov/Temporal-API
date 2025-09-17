package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.neoforged.neoforge.registries.DeferredHolder;

public class MaterialRuleFactory extends AbstractObjectFactory<MapCodec<? extends SurfaceRules.RuleSource>> {
    public MaterialRuleFactory() {
        this(InjectionPool.getFromInstance("$MaterialRules"));
    }

    public MaterialRuleFactory(TemporalRegister<MapCodec<? extends SurfaceRules.RuleSource>> register) {
        super(register);
    }

    public <T extends SurfaceRules.RuleSource> DeferredHolder<MapCodec<? extends SurfaceRules.RuleSource>, MapCodec<? extends T>> create(String name, KeyDispatchDataCodec<? extends T> codec) {
        return this.create(name, codec::codec);
    }
}
