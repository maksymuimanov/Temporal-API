package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.Codec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.advancements.critereon.ItemSubPredicate;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ItemSubPredicateTypeFactory extends AbstractObjectFactory<ItemSubPredicate.Type<?>> {
    public ItemSubPredicateTypeFactory() {
        this(InjectionPool.getFromInstance("$ItemSubPredicateTypes"));
    }

    public ItemSubPredicateTypeFactory(TemporalRegister<ItemSubPredicate.Type<?>> register) {
        super(register);
    }

    public <T extends ItemSubPredicate> DeferredHolder<ItemSubPredicate.Type<?>, ItemSubPredicate.Type<T>> create(String name, Codec<T> codec) {
        return this.create(name, () -> new ItemSubPredicate.Type<>(codec));
    }
}
