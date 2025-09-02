package com.temporal.api.core.engine.event.data.enchantment;

import net.minecraft.world.entity.EquipmentSlotGroup;

public record EnchantmentDescription(EnchantmentCompatibility compatibility,
                                     int weight, int maxLevel,
                                     EnchantmentCost cost,
                                     EquipmentSlotGroup[] equipmentSlots) {
}
