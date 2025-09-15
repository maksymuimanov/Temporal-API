package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.storage.loot.providers.score.LootScoreProviderType;

public class LootScoreProviderTypeFactory extends AbstractObjectFactory<LootScoreProviderType> {
    public LootScoreProviderTypeFactory() {
        this(InjectionPool.getFromInstance("$LootScoreProviderTypes"));
    }

    public LootScoreProviderTypeFactory(TemporalRegister<LootScoreProviderType> register) {
        super(register);
    }
}
