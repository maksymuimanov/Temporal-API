package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.item.enchantment.effects.EnchantmentValueEffect;

public class EnchantmentValueEffectTypeFactory extends AbstractObjectFactory<MapCodec<? extends EnchantmentValueEffect>> {
    public EnchantmentValueEffectTypeFactory() {
        this(InjectionPool.getFromInstance("$EnchantmentValueEffectTypes"));
    }

    public EnchantmentValueEffectTypeFactory(TemporalRegister<MapCodec<? extends EnchantmentValueEffect>> enchantmentValueEffectTypes) {
        super(enchantmentValueEffectTypes);
    }
}
