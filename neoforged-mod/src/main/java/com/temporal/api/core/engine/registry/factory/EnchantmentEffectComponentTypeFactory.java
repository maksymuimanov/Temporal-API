package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.core.component.DataComponentType;

public class EnchantmentEffectComponentTypeFactory extends AbstractObjectFactory<DataComponentType<?>> {
    public EnchantmentEffectComponentTypeFactory() {
        this(InjectionPool.getFromInstance("$EnchantmentEffectComponentTypes"));
    }

    public EnchantmentEffectComponentTypeFactory(TemporalRegister<DataComponentType<?>> register) {
        super(register);
    }
}
