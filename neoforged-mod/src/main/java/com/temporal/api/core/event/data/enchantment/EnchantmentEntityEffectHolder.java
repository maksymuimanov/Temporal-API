package com.temporal.api.core.event.data.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentTarget;
import net.minecraft.world.item.enchantment.TargetedConditionalEffect;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;

import java.util.List;

public interface EnchantmentEntityEffectHolder extends EnchantmentEffect<EnchantmentEntityEffect, List<TargetedConditionalEffect<EnchantmentEntityEffect>>> {
    EnchantmentTarget getEnchanted();

    EnchantmentTarget getAffected();
}
