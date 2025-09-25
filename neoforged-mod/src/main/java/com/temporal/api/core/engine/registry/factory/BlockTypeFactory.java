package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.block.Block;

public class BlockTypeFactory extends AbstractObjectFactory<MapCodec<? extends Block>> {
    public BlockTypeFactory() {
        this(InjectionPool.getFromInstance("$BlockTypes"));
    }

    public BlockTypeFactory(TemporalRegister<MapCodec<? extends Block>> register) {
        super(register);
    }
}
