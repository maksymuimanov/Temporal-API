package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;

public class DecoratedPotPatternFactory extends AbstractObjectFactory<DecoratedPotPattern> {
    public DecoratedPotPatternFactory() {
        this(InjectionPool.getFromInstance("$DecoratedPotPatterns"));
    }

    public DecoratedPotPatternFactory(TemporalRegister<DecoratedPotPattern> register) {
        super(register);
    }
}
