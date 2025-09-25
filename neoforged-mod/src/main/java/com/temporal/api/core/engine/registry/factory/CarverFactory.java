package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.carver.WorldCarver;

public class CarverFactory extends AbstractObjectFactory<WorldCarver<?>> {
    public CarverFactory() {
        this(InjectionPool.getFromInstance("$Carvers"));
    }

    public CarverFactory(TemporalRegister<WorldCarver<?>> register) {
        super(register);
    }
}
