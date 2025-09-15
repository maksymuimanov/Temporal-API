package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.effect.MobEffect;

public class MobEffectFactory extends AbstractObjectFactory<MobEffect> {
    public MobEffectFactory() {
        this(InjectionPool.getFromInstance("$MobEffects"));
    }

    public MobEffectFactory(final TemporalRegister<MobEffect> register) {
        super(register);
    }
}
