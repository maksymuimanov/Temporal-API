package com.temporal.api.core.engine.metadata.annotation.data;

import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DeathMessageType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenerateDamageType {
    DamageScaling scaling() default DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER;
    float exhaustion() default 0.1F;
    DamageEffects effects() default DamageEffects.HURT;
    DeathMessageType message() default DeathMessageType.DEFAULT;
}