package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;

public class LootFunctionTypeFactory extends AbstractObjectFactory<LootItemFunctionType<?>> {
    public LootFunctionTypeFactory() {
        this(InjectionPool.getFromInstance("$LootFunctionTypes"));
    }

    public LootFunctionTypeFactory(TemporalRegister<LootItemFunctionType<?>> register) {
        super(register);
    }
}
