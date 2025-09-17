package com.temporal.api.core.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.structure.templatesystem.rule.blockentity.RuleBlockEntityModifier;
import net.minecraft.world.level.levelgen.structure.templatesystem.rule.blockentity.RuleBlockEntityModifierType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class RuleBlockEntityModifierFactory extends AbstractObjectFactory<RuleBlockEntityModifierType<?>> {
    public RuleBlockEntityModifierFactory() {
        this(InjectionPool.getFromInstance("$RuleBlockEntityModifiers"));
    }

    public RuleBlockEntityModifierFactory(TemporalRegister<RuleBlockEntityModifierType<?>> register) {
        super(register);
    }

    public <T extends RuleBlockEntityModifier> DeferredHolder<RuleBlockEntityModifierType<?>, RuleBlockEntityModifierType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> () -> mapCodec);
    }
}
