package com.temporal.api.core.registry.factory;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.TemporalRegister;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.neoforge.registries.DeferredHolder;

public class PotionFactory extends AbstractObjectFactory<Potion> {
    public PotionFactory() {
        this(InjectionPool.getFromInstance("$Potions"));
    }

    public PotionFactory(TemporalRegister<Potion> potions) {
        super(potions);
    }

    public DeferredHolder<Potion, Potion> create(String name, Holder<MobEffect> effect, int duration) {
        return this.create(name, new MobEffectInstance(effect, duration));
    }

    public DeferredHolder<Potion, Potion> create(String name, MobEffectInstance mobEffectInstance) {
        return this.create(name, () -> new Potion(name, mobEffectInstance));
    }
}
