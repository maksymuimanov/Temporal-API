package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTestType;

public class RuleTestFactory extends AbstractObjectFactory<RuleTestType<?>> {
    public RuleTestFactory() {
        this(InjectionPool.getFromInstance("$RuleTests"));
    }

    public RuleTestFactory(TemporalRegister<RuleTestType<?>> register) {
        super(register);
    }
}
