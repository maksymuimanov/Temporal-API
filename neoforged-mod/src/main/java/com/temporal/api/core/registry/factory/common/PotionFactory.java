package com.temporal.api.core.registry.factory.common;

import com.temporal.api.core.engine.io.context.InjectionPool;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PotionFactory extends AbstractObjectFactory<Potion> {
    private final DeferredRegister<Potion> potions;

    public PotionFactory() {
        this(InjectionPool.getFromInstance("$Potions"));
    }

    public PotionFactory(DeferredRegister<Potion> potions) {
        this.potions = potions;
    }

    public DeferredHolder<Potion, Potion> create(String name, MobEffectInstance mobEffectInstance) {
        return create(name, () -> new Potion(name, mobEffectInstance));
    }

    public DeferredHolder<Potion, Potion> create(String name, Holder<MobEffect> effect, int duration) {
        return create(name, () -> new Potion(name, new MobEffectInstance(effect, duration)));
    }


    @Override
    public DeferredRegister<Potion> getRegistry() {
        return potions;
    }
}
