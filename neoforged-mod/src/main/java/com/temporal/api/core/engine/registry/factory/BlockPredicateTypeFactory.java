package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicateType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class BlockPredicateTypeFactory extends AbstractObjectFactory<BlockPredicateType<?>> {
    public BlockPredicateTypeFactory() {
        this(InjectionPool.getFromInstance("$BlockPredicateTypes"));
    }

    public BlockPredicateTypeFactory(TemporalRegister<BlockPredicateType<?>> register) {
        super(register);
    }

    public <T extends BlockPredicate> DeferredHolder<BlockPredicateType<?>, BlockPredicateType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> () -> mapCodec);
    }
}
