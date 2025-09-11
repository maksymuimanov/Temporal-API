package com.temporal.api.core.engine.metadata.strategy.field.data;

import com.temporal.api.core.engine.event.data.enchantment.ApiEnchantmentProvider;
import com.temporal.api.core.engine.event.data.enchantment.EnchantmentDescription;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.GenerateEnchantment;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateEnchantmentStrategy implements FieldAnnotationStrategy<GenerateEnchantment> {
    @Override
    public void execute(Field field, Object object, GenerateEnchantment annotation) throws Exception {
        ResourceKey<Enchantment> enchantment = (ResourceKey<Enchantment>) field.get(object);
        Constructor<?> constructor = annotation.value().getDeclaredConstructor();
        constructor.setAccessible(true);
        EnchantmentDescription descriptionHolder = (EnchantmentDescription) constructor.newInstance();
        ApiEnchantmentProvider.ENCHANTMENTS.put(enchantment, descriptionHolder);
    }

    @Override
    public Class<? extends GenerateEnchantment> getAnnotationClass() {
        return GenerateEnchantment.class;
    }
}
