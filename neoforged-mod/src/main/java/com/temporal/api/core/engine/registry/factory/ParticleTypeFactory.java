package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ParticleTypeFactory extends AbstractObjectFactory<ParticleType<?>> {
    public ParticleTypeFactory() {
        this(InjectionPool.getFromInstance("$ParticleTypes"));
    }

    public ParticleTypeFactory(TemporalRegister<ParticleType<?>> register) {
        super(register);
    }

    public DeferredHolder<ParticleType<?>, ParticleType<SimpleParticleType>> create(String name, boolean overrideLimiter) {
        return this.create(name, () -> new SimpleParticleType(overrideLimiter));
    }
}
