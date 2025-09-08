package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.Codec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.registries.DeferredHolder;

public class DataComponentTypeFactory extends AbstractObjectFactory<DataComponentType<?>> {
    public DataComponentTypeFactory() {
        this(InjectionPool.getFromInstance("$DataComponentTypes"));
    }

    public DataComponentTypeFactory(TemporalRegister<DataComponentType<?>> dataComponentTypes) {
        super(dataComponentTypes);
    }

    public <T> DeferredHolder<DataComponentType<?>, DataComponentType<T>> create(String name, Codec<T> codec, StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec) {
        return this.create(name, () -> DataComponentType.<T>builder()
                .persistent(codec)
                .networkSynchronized(streamCodec)
                .build());
    }
}