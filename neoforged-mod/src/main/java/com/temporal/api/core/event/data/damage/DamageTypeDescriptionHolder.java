package com.temporal.api.core.event.data.damage;

import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DeathMessageType;

public record DamageTypeDescriptionHolder(DamageScaling damageScaling, float exhaustion, DamageEffects effects, DeathMessageType messageType) {
}
