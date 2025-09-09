package com.temporal.api.core.engine.metadata.strategy.field.event.particle;

import com.temporal.api.core.engine.event.handler.RegisterParticleProvidersEventHandler;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.event.particle.RegisterParticleProvider;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_EVENT_PARTICLE)
public class RegisterParticleProviderStrategy implements FieldAnnotationStrategy<RegisterParticleProvider> {
    @Override
    public void execute(Field field, Object object, RegisterParticleProvider annotation) throws Exception {
        Holder<? extends ParticleType<ParticleOptions>> particleTypeHolder = (Holder<ParticleType<ParticleOptions>>) field.get(object);
        Class<? extends ParticleProvider<?>> providerClass = annotation.value();
        Constructor<? extends ParticleProvider<?>> providerConstructor = providerClass.getDeclaredConstructor(SpriteSet.class);
        RegisterParticleProvidersEventHandler.PROVIDER_REGISTRIES.add(event -> {
            event.registerSpriteSet(particleTypeHolder.value(), spriteSet -> {
                try {
                    return (ParticleProvider<ParticleOptions>) providerConstructor.newInstance(spriteSet);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            });
        });
    }

    @Override
    public Class<? extends RegisterParticleProvider> getAnnotationClass() {
        return RegisterParticleProvider.class;
    }
}
