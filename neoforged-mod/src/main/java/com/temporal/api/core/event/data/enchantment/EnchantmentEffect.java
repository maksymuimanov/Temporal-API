package com.temporal.api.core.event.data.enchantment;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;

public interface EnchantmentEffect<T, D> {
    ResourceKey<Enchantment> getKey();

    DataComponentType<D> getDataComponent();

    T getEffect();
}
