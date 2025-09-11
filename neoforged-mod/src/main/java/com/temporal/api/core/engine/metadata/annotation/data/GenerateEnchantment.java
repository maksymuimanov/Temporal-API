package com.temporal.api.core.engine.metadata.annotation.data;

import com.temporal.api.core.engine.event.data.enchantment.EnchantmentDescription;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenerateEnchantment {
    Class<? extends EnchantmentDescription> value();
}