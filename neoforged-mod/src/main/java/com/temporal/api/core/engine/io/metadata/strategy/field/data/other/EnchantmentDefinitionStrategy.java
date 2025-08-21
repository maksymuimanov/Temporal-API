package com.temporal.api.core.engine.io.metadata.strategy.field.data.other;

import com.temporal.api.core.engine.io.metadata.annotation.data.GenerateEnchantment;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.enchantment.ApiEnchantmentProvider;
import com.temporal.api.core.event.data.enchantment.EnchantmentCompatibility;
import com.temporal.api.core.event.data.enchantment.EnchantmentCost;
import com.temporal.api.core.event.data.enchantment.EnchantmentDescriptionHolder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class EnchantmentDefinitionStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        ResourceKey<Enchantment> enchantment = (ResourceKey<Enchantment>) field.get(object);
        GenerateEnchantment annotation = field.getDeclaredAnnotation(GenerateEnchantment.class);
        EnchantmentDescriptionHolder descriptionHolder = getDescriptionHolder(annotation);
        ApiEnchantmentProvider.ENCHANTMENTS.put(enchantment, descriptionHolder);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return GenerateEnchantment.class;
    }

    private @NotNull EnchantmentDescriptionHolder getDescriptionHolder(GenerateEnchantment annotation) {
        GenerateEnchantment.Compatibility compatibility = annotation.compatibility();
        EnchantmentCompatibility enchantmentCompatibility = new EnchantmentCompatibility(compatibility.compatibleItemsTag(), compatibility.primaryItemsTag(), compatibility.incompatibleEnchantmentId());
        GenerateEnchantment.Cost minCost = annotation.minCost();
        GenerateEnchantment.Cost maxCost = annotation.maxCost();
        EnchantmentCost enchantmentCost = new EnchantmentCost(Enchantment.dynamicCost(minCost.base(), minCost.perLevelAboveFirst()), Enchantment.dynamicCost(maxCost.base(), maxCost.perLevelAboveFirst()), annotation.anvilCost());
        return new EnchantmentDescriptionHolder(enchantmentCompatibility, annotation.weight(), annotation.maxLevel(), enchantmentCost, annotation.equipmentSlots());
    }
}
