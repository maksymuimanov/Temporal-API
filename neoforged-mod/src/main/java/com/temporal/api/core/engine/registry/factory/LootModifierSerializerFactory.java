package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;

public class LootModifierSerializerFactory extends AbstractObjectFactory<MapCodec<? extends IGlobalLootModifier>> {
    public LootModifierSerializerFactory() {
        this(InjectionPool.getFromInstance("$GlobalLootModifierSerializers"));
    }

    public LootModifierSerializerFactory(TemporalRegister<MapCodec<? extends IGlobalLootModifier>> lootModifierSerializers) {
        super(lootModifierSerializers);
    }
}
