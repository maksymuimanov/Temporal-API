package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.chunk.status.ChunkStatus;

public class ChunkStatusFactory extends AbstractObjectFactory<ChunkStatus> {
    public ChunkStatusFactory() {
        this(InjectionPool.getFromInstance("$ChunkStatuses"));
    }

    public ChunkStatusFactory(TemporalRegister<ChunkStatus> register) {
        super(register);
    }
}
