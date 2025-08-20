package com.temporal.api.core.registry.factory.common;

import com.temporal.api.core.engine.io.context.InjectionPool;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ParticleFactory extends AbstractObjectFactory<ParticleType<?>> {
    private final DeferredRegister<ParticleType<?>> particleTypes;

    public ParticleFactory() {
        this(InjectionPool.getFromInstance("$ParticleTypes"));
    }

    public ParticleFactory(DeferredRegister<ParticleType<?>> particleTypes) {
        this.particleTypes = particleTypes;
    }

    public Holder<ParticleType<?>> create(String name, boolean overrideLimiter) {
        return create(name, () -> new SimpleParticleType(overrideLimiter));
    }

    @Override
    public DeferredRegister<ParticleType<?>> getRegistry() {
        return particleTypes;
    }
}
