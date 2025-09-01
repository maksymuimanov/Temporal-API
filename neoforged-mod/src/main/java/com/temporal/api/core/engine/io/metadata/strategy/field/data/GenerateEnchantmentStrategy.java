package com.temporal.api.core.engine.io.metadata.strategy.field.data;

import com.temporal.api.core.engine.io.metadata.annotation.data.GenerateEnchantment;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.enchantment.ApiEnchantmentProvider;
import com.temporal.api.core.event.data.enchantment.EnchantmentCompatibility;
import com.temporal.api.core.event.data.enchantment.EnchantmentCost;
import com.temporal.api.core.event.data.enchantment.EnchantmentDescription;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;

import java.lang.reflect.Field;

public class GenerateEnchantmentStrategy implements FieldAnnotationStrategy<GenerateEnchantment> {
    @Override
    public void execute(Field field, Object object, GenerateEnchantment annotation) throws Exception {
        ResourceKey<Enchantment> enchantment = (ResourceKey<Enchantment>) field.get(object);
        GenerateEnchantment.Compatibility compatibility = annotation.compatibility();
        EnchantmentCompatibility enchantmentCompatibility = new EnchantmentCompatibility(compatibility.compatibleItemsTag(), compatibility.primaryItemsTag(), compatibility.incompatibleEnchantmentId());
        GenerateEnchantment.Cost minCost = annotation.minCost();
        GenerateEnchantment.Cost maxCost = annotation.maxCost();
        EnchantmentCost enchantmentCost = new EnchantmentCost(Enchantment.dynamicCost(minCost.base(), minCost.perLevelAboveFirst()), Enchantment.dynamicCost(maxCost.base(), maxCost.perLevelAboveFirst()), annotation.anvilCost());
        EnchantmentDescription descriptionHolder = new EnchantmentDescription(enchantmentCompatibility, annotation.weight(), annotation.maxLevel(), enchantmentCost, annotation.equipmentSlots());
        ApiEnchantmentProvider.ENCHANTMENTS.put(enchantment, descriptionHolder);
    }

    @Override
    public Class<? extends GenerateEnchantment> getAnnotationClass() {
        return GenerateEnchantment.class;
    }
}
