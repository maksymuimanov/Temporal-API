package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;

public class EnchantmentEntityEffectTypeFactory extends AbstractObjectFactory<MapCodec<? extends EnchantmentEntityEffect>> {
    public EnchantmentEntityEffectTypeFactory() {
        this(InjectionPool.getFromInstance("$EnchantmentEntityEffectTypes"));
    }

    public EnchantmentEntityEffectTypeFactory(TemporalRegister<MapCodec<? extends EnchantmentEntityEffect>> register) {
        super(register);
    }
}
