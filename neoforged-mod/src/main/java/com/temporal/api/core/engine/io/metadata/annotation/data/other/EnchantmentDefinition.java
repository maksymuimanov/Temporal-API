package com.temporal.api.core.engine.io.metadata.annotation.data.other;

import net.minecraft.world.entity.EquipmentSlotGroup;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EnchantmentDefinition {
    int weight();
    int maxLevel();
    Compatibility compatibility();
    Cost minCost();
    Cost maxCost();
    int anvilCost();
    EquipmentSlotGroup[] equipmentSlots();

    @interface Compatibility {
        String compatibleItemsTag();
        String primaryItemsTag();
        String incompatibleEnchantmentId();
    }

    @interface Cost {
        int base();
        int perLevelAboveFirst();
    }
}