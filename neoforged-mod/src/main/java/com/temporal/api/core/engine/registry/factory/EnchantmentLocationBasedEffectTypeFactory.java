package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.item.enchantment.effects.EnchantmentLocationBasedEffect;

public class EnchantmentLocationBasedEffectTypeFactory extends AbstractObjectFactory<MapCodec<? extends EnchantmentLocationBasedEffect>> {
    public EnchantmentLocationBasedEffectTypeFactory() {
        this(InjectionPool.getFromInstance("$EnchantmentLocationBasedEffectTypes"));
    }

    public EnchantmentLocationBasedEffectTypeFactory(TemporalRegister<MapCodec<? extends EnchantmentLocationBasedEffect>> register) {
        super(register);
    }
}
