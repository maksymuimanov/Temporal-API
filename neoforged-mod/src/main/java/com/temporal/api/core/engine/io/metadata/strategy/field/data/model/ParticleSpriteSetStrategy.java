package com.temporal.api.core.engine.io.metadata.strategy.field.data.model;

import com.temporal.api.core.engine.io.metadata.annotation.data.model.GenerateParticleSpriteSet;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.particle.ApiParticleProvider;
import com.temporal.api.core.event.data.particle.ParticleSprite;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleType;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ParticleSpriteSetStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Holder<ParticleType<?>> particleType = (Holder<ParticleType<?>>) field.get(object);
        GenerateParticleSpriteSet annotation = field.getAnnotation(GenerateParticleSpriteSet.class);
        ParticleSprite particleSprite = new ParticleSprite(annotation.id(), annotation.count(), annotation.reverse());
        ApiParticleProvider.PARTICLE_SPRITES.put(particleType, particleSprite);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return GenerateParticleSpriteSet.class;
    }
}
