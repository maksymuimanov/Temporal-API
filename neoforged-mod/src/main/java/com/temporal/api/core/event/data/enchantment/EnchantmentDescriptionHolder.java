package com.temporal.api.core.event.data.enchantment;

import net.minecraft.world.entity.EquipmentSlotGroup;

public record EnchantmentDescriptionHolder(EnchantmentCompatibility compatibility,
                                           int weight, int maxLevel,
                                           EnchantmentCost cost,
                                           EquipmentSlotGroup[] equipmentSlots) {
}
