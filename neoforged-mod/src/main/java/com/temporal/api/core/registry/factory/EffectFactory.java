package com.temporal.api.core.registry.factory;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.TemporalRegister;
import net.minecraft.world.effect.MobEffect;

public class EffectFactory extends AbstractObjectFactory<MobEffect> {
    public EffectFactory() {
        this(InjectionPool.getFromInstance("$MobEffects"));
    }

    public EffectFactory(TemporalRegister<MobEffect> mobEffects) {
        super(mobEffects);
    }
}
