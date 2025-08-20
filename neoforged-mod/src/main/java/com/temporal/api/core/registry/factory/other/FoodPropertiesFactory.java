package com.temporal.api.core.registry.factory.other;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public final class FoodPropertiesFactory {
    private FoodPropertiesFactory() {
    }

    public static FoodProperties.Builder stew(int nutrition, float saturationModifier) {
        return simple(nutrition, saturationModifier).usingConvertsTo(Items.BOWL);
    }

    public static FoodProperties.Builder simple(int nutrition, float saturationModifier) {
        return new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturationModifier);
    }
}
