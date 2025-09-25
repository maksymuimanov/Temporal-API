package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.storage.loot.providers.score.LootScoreProviderType;
import net.minecraft.world.level.storage.loot.providers.score.ScoreboardNameProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

public class LootScoreProviderTypeFactory extends AbstractObjectFactory<LootScoreProviderType> {
    public LootScoreProviderTypeFactory() {
        this(InjectionPool.getFromInstance("$LootScoreProviderTypes"));
    }

    public LootScoreProviderTypeFactory(TemporalRegister<LootScoreProviderType> register) {
        super(register);
    }

    public DeferredHolder<LootScoreProviderType, LootScoreProviderType> create(String name, MapCodec<? extends ScoreboardNameProvider> mapCodec) {
        return super.create(name, () -> new LootScoreProviderType(mapCodec));
    }
}
