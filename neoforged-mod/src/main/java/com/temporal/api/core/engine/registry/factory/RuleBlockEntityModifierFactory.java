package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.structure.templatesystem.rule.blockentity.RuleBlockEntityModifierType;

public class RuleBlockEntityModifierFactory extends AbstractObjectFactory<RuleBlockEntityModifierType<?>> {
    public RuleBlockEntityModifierFactory() {
        this(InjectionPool.getFromInstance("$RuleBlockEntityModifiers"));
    }

    public RuleBlockEntityModifierFactory(TemporalRegister<RuleBlockEntityModifierType<?>> register) {
        super(register);
    }
}
