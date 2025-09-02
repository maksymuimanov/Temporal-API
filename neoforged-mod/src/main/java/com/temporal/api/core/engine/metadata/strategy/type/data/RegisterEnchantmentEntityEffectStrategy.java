package com.temporal.api.core.engine.metadata.strategy.type.data;

import com.temporal.api.core.engine.event.data.enchantment.ApiEnchantmentProvider;
import com.temporal.api.core.engine.event.data.enchantment.EnchantmentEntityEffectHolder;
import com.temporal.api.core.engine.metadata.annotation.data.RegisterEnchantmentEntityEffect;
import com.temporal.api.core.engine.metadata.strategy.type.ClassAnnotationStrategy;

import java.lang.reflect.Constructor;

public class RegisterEnchantmentEntityEffectStrategy implements ClassAnnotationStrategy<RegisterEnchantmentEntityEffect> {
    @Override
    public void execute(Class<?> clazz, Object object, RegisterEnchantmentEntityEffect annotation) throws Exception {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        EnchantmentEntityEffectHolder effectHolder = (EnchantmentEntityEffectHolder) constructor.newInstance();
        ApiEnchantmentProvider.ENTITY_EFFECTS.put(effectHolder.getKey(), effectHolder);
    }

    @Override
    public Class<? extends RegisterEnchantmentEntityEffect> getAnnotationClass() {
        return RegisterEnchantmentEntityEffect.class;
    }
}
