package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.neoforged.neoforge.fluids.crafting.FluidIngredientType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class FluidIngredientTypeFactory extends AbstractObjectFactory<FluidIngredientType<?>> {
    public FluidIngredientTypeFactory() {
        this(InjectionPool.getFromInstance("$FluidIngredientTypes"));
    }

    public FluidIngredientTypeFactory(TemporalRegister<FluidIngredientType<?>> register) {
        super(register);
    }

    public <T extends FluidIngredient> DeferredHolder<FluidIngredientType<?>, FluidIngredientType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, mapCodec, ByteBufCodecs.fromCodecWithRegistries(mapCodec.codec()));
    }

    public <T extends FluidIngredient> DeferredHolder<FluidIngredientType<?>, FluidIngredientType<T>> create(String name, MapCodec<T> mapCodec, StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec) {
        return this.create(name, () -> new FluidIngredientType<>(mapCodec, streamCodec));
    }
}
