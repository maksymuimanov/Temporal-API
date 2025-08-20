package com.temporal.api.core.engine.io.metadata.annotation.data.other;

import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DeathMessageType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DamageTypeDescription {
    DamageScaling damageScaling();
    float exhaustion();
    DamageEffects effects();
    DeathMessageType messageType();
}