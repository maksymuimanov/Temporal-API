package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;

public class BlockstateProviderTypeFactory extends AbstractObjectFactory<BlockStateProviderType<?>> {
    public BlockstateProviderTypeFactory() {
        this(InjectionPool.getFromInstance("$BlockstateProviderTypes"));
    }

    public BlockstateProviderTypeFactory(TemporalRegister<BlockStateProviderType<?>> register) {
        super(register);
    }
}
