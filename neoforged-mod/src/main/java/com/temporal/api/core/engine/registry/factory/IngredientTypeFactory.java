package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.common.crafting.ICustomIngredient;
import net.neoforged.neoforge.common.crafting.IngredientType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class IngredientTypeFactory extends AbstractObjectFactory<IngredientType<?>> {
    public IngredientTypeFactory() {
        this(InjectionPool.getFromInstance("$IngredientTypes"));
    }

    public IngredientTypeFactory(TemporalRegister<IngredientType<?>> register) {
        super(register);
    }

    public <T extends ICustomIngredient> DeferredHolder<IngredientType<?>, IngredientType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, mapCodec, ByteBufCodecs.fromCodecWithRegistries(mapCodec.codec()));
    }

    public <T extends ICustomIngredient> DeferredHolder<IngredientType<?>, IngredientType<T>> create(String name, MapCodec<T> mapCodec, StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec) {
        return this.create(name, () -> new IngredientType<>(mapCodec, streamCodec));
    }
}
