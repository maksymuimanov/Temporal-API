package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.Codec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Optional;

public class MemoryModuleTypeFactory extends AbstractObjectFactory<MemoryModuleType<?>> {
    public MemoryModuleTypeFactory() {
        this(InjectionPool.getFromInstance("$MemoryModuleTypes"));
    }

    public MemoryModuleTypeFactory(TemporalRegister<MemoryModuleType<?>> register) {
        super(register);
    }

    public <T> DeferredHolder<MemoryModuleType<?>, MemoryModuleType<T>> create(String name) {
        return this.create(name, Optional.empty());
    }

    public <T> DeferredHolder<MemoryModuleType<?>, MemoryModuleType<T>> create(String name, Codec<T> codec) {
        return this.create(name, Optional.of(codec));
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public <T> DeferredHolder<MemoryModuleType<?>, MemoryModuleType<T>> create(String name, Optional<Codec<T>> optional) {
        return this.create(name, () -> new MemoryModuleType<>(optional));
    }
}
