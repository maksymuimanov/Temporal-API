package com.temporal.api.core.engine.metadata.strategy.field.data.model;

import com.temporal.api.core.engine.event.data.particle.ApiParticleProvider;
import com.temporal.api.core.engine.event.data.particle.ParticleDescription;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.MetadataLayer;
import com.temporal.api.core.engine.metadata.annotation.data.model.GenerateParticleSpriteSet;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.executor.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleType;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateParticleSpriteSetStrategy implements FieldAnnotationStrategy<GenerateParticleSpriteSet> {
    @Override
    public void execute(Field field, Object object, GenerateParticleSpriteSet annotation) throws Exception {
        Holder<ParticleType<?>> particleType = (Holder<ParticleType<?>>) field.get(object);
        ParticleDescription particleDescription = new ParticleDescription(annotation.id(), annotation.count(), annotation.reverse());
        ApiParticleProvider.PARTICLE_SPRITES.put(particleType, particleDescription);
    }

    @Override
    public Class<? extends GenerateParticleSpriteSet> getAnnotationClass() {
        return GenerateParticleSpriteSet.class;
    }

    @Override
    public AnnotationExecutor<? extends AnnotationStrategy<Field, ?>> getExecutor() {
        return MetadataLayer.STATIC_FIELD_EXECUTOR;
    }
}
