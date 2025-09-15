package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.storage.loot.providers.nbt.LootNbtProviderType;

public class LootNbtProviderTypeFactory extends AbstractObjectFactory<LootNbtProviderType> {
    public LootNbtProviderTypeFactory() {
        this(InjectionPool.getFromInstance("$LootNbtProviderTypes"));
    }

    public LootNbtProviderTypeFactory(TemporalRegister<LootNbtProviderType> register) {
        super(register);
    }
}
