package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class MaterialRuleFactory extends AbstractObjectFactory<MapCodec<? extends SurfaceRules.RuleSource>> {
    public MaterialRuleFactory() {
        this(InjectionPool.getFromInstance("$MaterialRules"));
    }

    public MaterialRuleFactory(TemporalRegister<MapCodec<? extends SurfaceRules.RuleSource>> register) {
        super(register);
    }
}
