package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.item.enchantment.providers.EnchantmentProvider;

public class EnchantmentProviderTypeFactory extends AbstractObjectFactory<MapCodec<? extends EnchantmentProvider>> {
    public EnchantmentProviderTypeFactory() {
        this(InjectionPool.getFromInstance("$EnchantmentProviderTypes"));
    }

    public EnchantmentProviderTypeFactory(TemporalRegister<MapCodec<? extends EnchantmentProvider>> register) {
        super(register);
    }
}
