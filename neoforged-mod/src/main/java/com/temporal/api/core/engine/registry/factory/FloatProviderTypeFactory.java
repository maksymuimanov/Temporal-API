package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.FloatProviderType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class FloatProviderTypeFactory extends AbstractObjectFactory<FloatProviderType<?>> {
    public FloatProviderTypeFactory() {
        this(InjectionPool.getFromInstance("$FloatProviderTypes"));
    }

    public FloatProviderTypeFactory(TemporalRegister<FloatProviderType<?>> register) {
        super(register);
    }

    public <T extends FloatProvider> DeferredHolder<FloatProviderType<?>, FloatProviderType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> () -> mapCodec);
    }
}
