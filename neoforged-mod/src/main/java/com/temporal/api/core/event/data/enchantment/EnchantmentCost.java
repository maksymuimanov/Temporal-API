package com.temporal.api.core.event.data.enchantment;

import net.minecraft.world.item.enchantment.Enchantment;

public record EnchantmentCost(Enchantment.Cost minCost, Enchantment.Cost maxCost, int anvilCost) {
}
