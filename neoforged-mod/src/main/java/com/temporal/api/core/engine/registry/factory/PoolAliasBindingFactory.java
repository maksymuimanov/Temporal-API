package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.structure.pools.alias.PoolAliasBinding;

public class PoolAliasBindingFactory extends AbstractObjectFactory<MapCodec<? extends PoolAliasBinding>> {
    public PoolAliasBindingFactory() {
        this(InjectionPool.getFromInstance("$PoolAliasBindings"));
    }

    public PoolAliasBindingFactory(TemporalRegister<MapCodec<? extends PoolAliasBinding>> register) {
        super(register);
    }
}
