package com.temporal.api.core.registry.factory;

import com.temporal.api.core.engine.io.context.InjectionPool;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ParticleFactory extends AbstractObjectFactory<ParticleType<?>> {
    public ParticleFactory() {
        this(InjectionPool.getFromInstance("$ParticleTypes"));
    }

    public ParticleFactory(DeferredRegister<ParticleType<?>> particleTypes) {
        super(particleTypes);
    }

    public DeferredHolder<ParticleType<?>, ParticleType<SimpleParticleType>> create(String name, boolean overrideLimiter) {
        return this.create(name, () -> new SimpleParticleType(overrideLimiter));
    }
}
