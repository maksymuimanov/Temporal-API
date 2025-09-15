package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;

public class LootConditionTypeFactory extends AbstractObjectFactory<LootItemConditionType> {
    public LootConditionTypeFactory() {
        this(InjectionPool.getFromInstance("$LootConditionTypes"));
    }

    public LootConditionTypeFactory(TemporalRegister<LootItemConditionType> register) {
        super(register);
    }
}
