package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.biome.BiomeSource;

public class BiomeSourceFactory extends AbstractObjectFactory<MapCodec<? extends BiomeSource>> {
    public BiomeSourceFactory() {
        this(InjectionPool.getFromInstance("$BiomeSources"));
    }

    public BiomeSourceFactory(TemporalRegister<MapCodec<? extends BiomeSource>> register) {
        super(register);
    }
}
