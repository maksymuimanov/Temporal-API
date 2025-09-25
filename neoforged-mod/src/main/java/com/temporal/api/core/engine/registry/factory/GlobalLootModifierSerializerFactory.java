package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;

public class GlobalLootModifierSerializerFactory extends AbstractObjectFactory<MapCodec<? extends IGlobalLootModifier>> {
    public GlobalLootModifierSerializerFactory() {
        this(InjectionPool.getFromInstance("$GlobalLootModifierSerializers"));
    }

    public GlobalLootModifierSerializerFactory(TemporalRegister<MapCodec<? extends IGlobalLootModifier>> register) {
        super(register);
    }
}
