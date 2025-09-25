package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class BlockStateProviderTypeFactory extends AbstractObjectFactory<BlockStateProviderType<?>> {
    public BlockStateProviderTypeFactory() {
        this(InjectionPool.getFromInstance("$BlockstateProviderTypes"));
    }

    public BlockStateProviderTypeFactory(TemporalRegister<BlockStateProviderType<?>> register) {
        super(register);
    }

    public <T extends BlockStateProvider> DeferredHolder<BlockStateProviderType<?>, BlockStateProviderType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> new BlockStateProviderType<>(mapCodec));
    }
}
