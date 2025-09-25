package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.item.enchantment.LevelBasedValue;

public class EnchantmentLevelBasedValueTypeFactory extends AbstractObjectFactory<MapCodec<? extends LevelBasedValue>> {
    public EnchantmentLevelBasedValueTypeFactory() {
        this(InjectionPool.getFromInstance("$EnchantmentLevelBasedValueTypes"));
    }

    public EnchantmentLevelBasedValueTypeFactory(TemporalRegister<MapCodec<? extends LevelBasedValue>> register) {
        super(register);
    }
}
