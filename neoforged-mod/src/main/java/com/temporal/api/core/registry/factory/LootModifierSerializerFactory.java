package com.temporal.api.core.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.io.context.InjectionPool;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;

public class LootModifierSerializerFactory extends AbstractObjectFactory<MapCodec<? extends IGlobalLootModifier>> {
    public LootModifierSerializerFactory() {
        this(InjectionPool.getFromInstance("$GlobalLootModifierSerializers"));
    }

    public LootModifierSerializerFactory(DeferredRegister<MapCodec<? extends IGlobalLootModifier>> lootModifierSerializers) {
        super(lootModifierSerializers);
    }
}
