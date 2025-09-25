package net.temporal.example.particle;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.metadata.annotation.data.model.GenerateParticleSpriteSet;
import com.temporal.api.core.engine.metadata.annotation.event.particle.RegisterParticleProvider;
import com.temporal.api.core.engine.registry.factory.ParticleTypeFactory;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.neoforge.registries.DeferredHolder;

public final class ExampleParticleTypes {
    private static final ParticleTypeFactory PARTICLE_TYPE_FACTORY = InjectionPool.getFromInstance(ParticleTypeFactory.class);

    @RegisterParticleProvider(ExampleParticle.Provider.class)
    @GenerateParticleSpriteSet(id = "example:example", count = 6)
    public static final DeferredHolder<ParticleType<?>, ParticleType<SimpleParticleType>> EXAMPLE_PARTICLE_TYPE = PARTICLE_TYPE_FACTORY.create("example", true);
}
