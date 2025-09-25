package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.chunk.ChunkGenerator;

public class ChunkGeneratorFactory extends AbstractObjectFactory<MapCodec<? extends ChunkGenerator>> {
    public ChunkGeneratorFactory() {
        this(InjectionPool.getFromInstance("$ChunkGenerators"));
    }

    public ChunkGeneratorFactory(TemporalRegister<MapCodec<? extends ChunkGenerator>> register) {
        super(register);
    }
}
