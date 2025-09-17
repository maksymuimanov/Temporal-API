package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class LootPoolEntryTypeFactory extends AbstractObjectFactory<LootPoolEntryType> {
    public LootPoolEntryTypeFactory() {
        this(InjectionPool.getFromInstance("$LootPoolEntryTypes"));
    }

    public LootPoolEntryTypeFactory(TemporalRegister<LootPoolEntryType> register) {
        super(register);
    }

    public DeferredHolder<LootPoolEntryType, LootPoolEntryType> create(String name, MapCodec<? extends LootPoolEntryContainer> mapCodec) {
        return this.create(name, () -> new LootPoolEntryType(mapCodec));
    }
}
