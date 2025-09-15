package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryType;

public class LootPoolEntryTypeFactory extends AbstractObjectFactory<LootPoolEntryType> {
    public LootPoolEntryTypeFactory() {
        this(InjectionPool.getFromInstance("$LootPoolEntryTypes"));
    }

    public LootPoolEntryTypeFactory(TemporalRegister<LootPoolEntryType> register) {
        super(register);
    }
}
