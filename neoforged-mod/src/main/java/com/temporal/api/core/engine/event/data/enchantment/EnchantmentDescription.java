package com.temporal.api.core.engine.event.data.enchantment;

import net.minecraft.core.HolderGetter;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;

public interface EnchantmentDescription {
    Enchantment.Builder build(HolderGetter<Enchantment> enchantments, HolderGetter<Item> items);
}
