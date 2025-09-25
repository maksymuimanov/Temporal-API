package com.temporal.api.core.engine.metadata.annotation.event.particle;

import net.minecraft.client.particle.ParticleProvider;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RegisterParticleProvider {
    Class<? extends ParticleProvider<?>> value();
}