package com.temporal.api.core.registry.factory.common;

import com.temporal.api.core.engine.io.context.InjectionPool;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EffectFactory extends AbstractObjectFactory<MobEffect> {
    private final DeferredRegister<MobEffect> mobEffects;

    public EffectFactory() {
        this(InjectionPool.getFromInstance("$MobEffects"));
    }

    public EffectFactory(DeferredRegister<MobEffect> mobEffects) {
        this.mobEffects = mobEffects;
    }

    @Override
    public DeferredRegister<MobEffect> getRegistry() {
        return mobEffects;
    }
}
