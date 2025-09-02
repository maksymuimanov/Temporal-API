package com.temporal.api.core.engine.event.data.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;

public class EnchantmentTransformer implements KeyTransformer<ResourceKey<Enchantment>> {
    @Override
    public String transform(ResourceKey<Enchantment> enchantment) {
        return this.transformResourceKey("enchantment", enchantment);
    }
}
