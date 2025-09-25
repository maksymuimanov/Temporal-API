package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class LootFunctionTypeFactory extends AbstractObjectFactory<LootItemFunctionType<?>> {
    public LootFunctionTypeFactory() {
        this(InjectionPool.getFromInstance("$LootFunctionTypes"));
    }

    public LootFunctionTypeFactory(TemporalRegister<LootItemFunctionType<?>> register) {
        super(register);
    }

    public <T extends LootItemFunction> DeferredHolder<LootItemFunctionType<?>, LootItemFunctionType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> new LootItemFunctionType<>(mapCodec));
    }
}
