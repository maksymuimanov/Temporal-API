package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class LootConditionTypeFactory extends AbstractObjectFactory<LootItemConditionType> {
    public LootConditionTypeFactory() {
        this(InjectionPool.getFromInstance("$LootConditionTypes"));
    }

    public LootConditionTypeFactory(TemporalRegister<LootItemConditionType> register) {
        super(register);
    }

    public DeferredHolder<LootItemConditionType, LootItemConditionType> create(String name, MapCodec<? extends LootItemCondition> mapCodec) {
        return this.create(name, () -> new LootItemConditionType(mapCodec));
    }
}
