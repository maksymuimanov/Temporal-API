package com.temporal.api.core.engine.io.metadata.strategy.field.data.model;

import com.temporal.api.core.engine.io.metadata.annotation.data.model.GenerateParticleSpriteSet;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.particle.ApiParticleProvider;
import com.temporal.api.core.event.data.particle.ParticleSprite;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleType;

import java.lang.reflect.Field;

public class GenerateParticleSpriteSetStrategy implements FieldAnnotationStrategy<GenerateParticleSpriteSet> {
    @Override
    public void execute(Field field, Object object, GenerateParticleSpriteSet annotation) throws Exception {
        Holder<ParticleType<?>> particleType = (Holder<ParticleType<?>>) field.get(object);
        ParticleSprite particleSprite = new ParticleSprite(annotation.id(), annotation.count(), annotation.reverse());
        ApiParticleProvider.PARTICLE_SPRITES.put(particleType, particleSprite);
    }

    @Override
    public Class<? extends GenerateParticleSpriteSet> getAnnotationClass() {
        return GenerateParticleSpriteSet.class;
    }
}
