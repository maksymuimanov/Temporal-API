package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.storage.loot.providers.number.LootNumberProviderType;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

public class LootNumberProviderTypeFactory extends AbstractObjectFactory<LootNumberProviderType> {
    public LootNumberProviderTypeFactory() {
        this(InjectionPool.getFromInstance("$LootNumberProviderTypes"));
    }

    public LootNumberProviderTypeFactory(TemporalRegister<LootNumberProviderType> register) {
        super(register);
    }

    public DeferredHolder<LootNumberProviderType, LootNumberProviderType> create(String name, MapCodec<? extends NumberProvider> mapCodec) {
        return this.create(name, () -> new LootNumberProviderType(mapCodec));
    }
}
