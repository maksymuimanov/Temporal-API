package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.structure.templatesystem.PosRuleTestType;

public class PosRuleTestFactory extends AbstractObjectFactory<PosRuleTestType<?>> {
    public PosRuleTestFactory() {
        this(InjectionPool.getFromInstance("$PosRuleTests"));
    }

    public PosRuleTestFactory(TemporalRegister<PosRuleTestType<?>> register) {
        super(register);
    }
}
