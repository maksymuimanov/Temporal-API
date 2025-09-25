package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.storage.loot.providers.nbt.LootNbtProviderType;
import net.minecraft.world.level.storage.loot.providers.nbt.NbtProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

public class LootNbtProviderTypeFactory extends AbstractObjectFactory<LootNbtProviderType> {
    public LootNbtProviderTypeFactory() {
        this(InjectionPool.getFromInstance("$LootNbtProviderTypes"));
    }

    public LootNbtProviderTypeFactory(TemporalRegister<LootNbtProviderType> register) {
        super(register);
    }

    public DeferredHolder<LootNbtProviderType, LootNbtProviderType> create(String name, MapCodec<? extends NbtProvider> mapCodec) {
        return this.create(name, () -> new LootNbtProviderType(mapCodec));
    }
}
