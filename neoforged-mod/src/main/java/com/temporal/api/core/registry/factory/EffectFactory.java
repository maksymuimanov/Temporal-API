package com.temporal.api.core.registry.factory;

import com.temporal.api.core.engine.io.context.InjectionPool;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EffectFactory extends AbstractObjectFactory<MobEffect> {
    public EffectFactory() {
        this(InjectionPool.getFromInstance("$MobEffects"));
    }

    public EffectFactory(DeferredRegister<MobEffect> mobEffects) {
        super(mobEffects);
    }
}
