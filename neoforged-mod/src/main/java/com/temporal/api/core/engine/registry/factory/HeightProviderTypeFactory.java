package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.heightproviders.HeightProviderType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class HeightProviderTypeFactory extends AbstractObjectFactory<HeightProviderType<?>> {
    public HeightProviderTypeFactory() {
        this(InjectionPool.getFromInstance("$HeightProviderTypes"));
    }

    public HeightProviderTypeFactory(TemporalRegister<HeightProviderType<?>> register) {
        super(register);
    }

    public <T extends HeightProvider> DeferredHolder<HeightProviderType<?>, HeightProviderType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> () -> mapCodec);
    }
}
